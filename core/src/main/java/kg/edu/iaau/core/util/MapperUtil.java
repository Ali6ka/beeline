package kg.edu.iaau.core.util;

import kg.edu.iaau.core.entity.Point;
import kg.edu.iaau.core.entity.dto.PointDTO;
import kg.edu.iaau.core.service.CompanyService;
import kg.edu.iaau.core.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MapperUtil
{
    @Autowired
    private CompanyService companyService;

    @Autowired
    private PersonService personService;

    public Point dtoToPoint(PointDTO pointDTO)
    {
        Point point = new Point();
        point.setName(pointDTO.getName());
        point.setCompany(companyService.getById(pointDTO.getCompanyId()));
        point.setPhoneNumber(pointDTO.getPhoneNumber());
        point.setAddress(pointDTO.getAddress());
        point.setLatitude(pointDTO.getLatitude());
        point.setLongitude(pointDTO.getLongitude());
        point.setPerson(personService.getById(pointDTO.getUserId()));

        return point;
    }

    public PointDTO pointToDto(Point point)
    {
        PointDTO pointDTO = new PointDTO();
        pointDTO.setId(point.getId());
        pointDTO.setName(point.getName());
        pointDTO.setCompanyId(point.getCompany().getId());
        pointDTO.setPhoneNumber(point.getPhoneNumber());
        pointDTO.setAddress(point.getAddress());
        pointDTO.setLatitude(point.getLatitude());
        pointDTO.setLongitude(point.getLongitude());
        pointDTO.setUserId(point.getPerson().getId());

        return pointDTO;
    }

    public Point updatePoint(PointDTO pointDTO, Point point , Boolean isAdmin)
    {
        if(pointDTO.getName() != null) {
            point.setName(pointDTO.getName());
        }
        if(pointDTO.getPhoneNumber() != null){
            point.setPhoneNumber(pointDTO.getPhoneNumber());
        }
        if(pointDTO.getAddress() != null){
            point.setAddress(pointDTO.getAddress());
        }
        if(pointDTO.getLatitude() != null){
            point.setLatitude(pointDTO.getLatitude());
        }
        if(pointDTO.getLongitude() != null){
            point.setLongitude(pointDTO.getLongitude());
        }
        if(isAdmin && pointDTO.getUserId() != null){
            point.setPerson(personService.getById(pointDTO.getUserId()));
        }

        return point;
    }

}
