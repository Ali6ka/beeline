package kg.edu.iaau.api.controller;

import kg.edu.iaau.api.util.ResponseUtil;
import kg.edu.iaau.core.entity.Company;
import kg.edu.iaau.core.entity.dto.CompanyDTO;
import kg.edu.iaau.core.service.CompanyService;
import kg.edu.iaau.core.service.PersonService;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import static kg.edu.iaau.core.transfer.Groups.New;
import static kg.edu.iaau.core.transfer.Groups.Update;

@RestController
@RequestMapping(value = "/api/companies")
public class CompanyController
{
    @Autowired
    private PersonService personService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ResponseUtil responseUtil;

    @GetMapping
    public ResponseEntity getCompanies()
    {
        List<Company> companyList = companyService.getAll();

        List<CompanyDTO> companyDTOList = companyList.stream()
                .map(company -> mapper.map(company, CompanyDTO.class))
                .collect(Collectors.toList());

        return responseUtil.responseBuilder("SUCCESS",
                "getCompany", companyDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(Principal principal, @Validated(New.class)
    @RequestBody CompanyDTO companyDTO)
    {
        if(!personService.isAdmin(principal.getName()))
        {
            return responseUtil.responseBuilder("ERROR",
                    "notAllowed", HttpStatus.METHOD_NOT_ALLOWED);
        }

        Company company = mapper.map(companyDTO, Company.class);
        Company companyCreated = companyService.save(company);
        CompanyDTO dto = mapper.map(companyCreated, CompanyDTO.class);

        return responseUtil.responseBuilder("SUCCESS",
                "postCompany", dto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCompany( Principal principal,
                                        @PathVariable int id,
                                        @Validated(Update.class)
                                        @RequestBody CompanyDTO companyDTO)
    {
        if(!personService.isAdmin(principal.getName()))
        {
            return responseUtil.responseBuilder("ERROR",
                    "notAllowed", HttpStatus.METHOD_NOT_ALLOWED);
        }

        Company company = companyService.getById(id);
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        mapper.map(companyDTO, company);

        companyService.save(company);

        CompanyDTO dto = mapper.map(company, CompanyDTO.class);

        return responseUtil.responseBuilder("SUCCESS",
                "infoUpdated", dto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCompany(@PathVariable int id, Principal principal)
    {
        if(!personService.isAdmin(principal.getName()))
        {
            return responseUtil.responseBuilder("ERROR",
                    "notAllowed", HttpStatus.METHOD_NOT_ALLOWED);
        }

        Company company = companyService.getById(id);
        companyService.delete(company);

        return responseUtil.responseBuilder("SUCCESS",
                "deleteCompany", HttpStatus.OK);
    }
}
