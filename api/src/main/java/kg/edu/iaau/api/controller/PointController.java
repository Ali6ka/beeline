package kg.edu.iaau.api.controller;

import kg.edu.iaau.api.util.ResponseUtil;
import kg.edu.iaau.core.entity.Company;
import kg.edu.iaau.core.entity.Person;
import kg.edu.iaau.core.entity.Point;
import kg.edu.iaau.core.entity.dto.PointDTO;
import kg.edu.iaau.core.service.CompanyService;
import kg.edu.iaau.core.service.PersonService;
import kg.edu.iaau.core.service.PointService;
import kg.edu.iaau.core.util.MapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import static kg.edu.iaau.core.transfer.Groups.New;
import static kg.edu.iaau.core.transfer.Groups.Update;

@RestController
@RequestMapping(value = "/api/points")
public class PointController
{
    @Autowired
    private PersonService personService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private PointService pointService;

    @Autowired
    private ResponseUtil responseUtil;

    @Autowired
    private MapperUtil mapperUtil;

    @GetMapping
    public ResponseEntity getPoints(Principal principal,
                                    @RequestParam(name = "companyId", required = false) Integer companyId)
    {
        Person person = personService.findByUsername(principal.getName());
        List<Point> points;

        if(companyId != null)
        {
            Company company = companyService.getById(companyId);

            if(!person.getIsAdmin()) {
                points = pointService.getByUserAndCompany(person, company);

            } else {
                points = pointService.getByCompany(company);
            }
        } else {

            if(!person.getIsAdmin()) {
                points = pointService.getByUser(person);

            } else {
                points = pointService.getAll();
            }
        }

        List<PointDTO> pointDTOList = points.stream()
                .map(point -> mapperUtil.pointToDto(point))
                .collect(Collectors.toList());

        return responseUtil.responseBuilder("SUCCESS",
                "getPoint", pointDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createPoint(Principal principal, @Validated(New.class)
    @RequestBody PointDTO pointDTO)
    {
        Person person = personService.findByUsername(principal.getName());

        if(!person.getIsAdmin() || pointDTO.getUserId() == 0)
        {
            pointDTO.setUserId(person.getId());
        }

        Point point = mapperUtil.dtoToPoint(pointDTO);

        Point pointCreated = pointService.save(point);
        PointDTO dto = mapperUtil.pointToDto(pointCreated);

        return responseUtil.responseBuilder("SUCCESS",
                "postPoint", dto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePoint( Principal principal,
                                         @PathVariable int id,
                                         @Validated(Update.class)
                                         @RequestBody PointDTO pointDTO)
    {
        Person person = personService.findByUsername(principal.getName());
        Point point = pointService.getById(id);
        point = mapperUtil.updatePoint(pointDTO, point, person.getIsAdmin());

        pointService.save(point);

        PointDTO dto = mapperUtil.pointToDto(point);

        return responseUtil.responseBuilder("SUCCESS",
                "infoUpdated", dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePoint(@PathVariable int id, Principal principal)
    {
        Point point = pointService.getById(id);

        Person person = personService.findByUsername(principal.getName());
        if(person.getIsAdmin() || person.getId() == point.getPerson().getId())
        {
            pointService.delete(pointService.getById(id));
            return responseUtil.responseBuilder("SUCCESS",
                    "deletePoint", HttpStatus.OK);
        } else {
            return responseUtil.responseBuilder("ERROR",
                    "notAllowed", HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
}
