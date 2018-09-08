package kg.edu.iaau.beeline.controller;

import kg.edu.iaau.beeline.entity.Company;
import kg.edu.iaau.beeline.entity.dto.CompanyDTO;
import kg.edu.iaau.beeline.service.CompanyService;
import kg.edu.iaau.beeline.service.PersonService;
import kg.edu.iaau.beeline.util.ResponseUtil;
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

import static kg.edu.iaau.beeline.transfer.Groups.New;
import static kg.edu.iaau.beeline.transfer.Groups.Update;

@RestController
@RequestMapping(value = "/companies")
public class CompanyController
{
    @Autowired
    private PersonService personService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

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
    public ResponseEntity deletePerson(@PathVariable int id, Principal principal)
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
