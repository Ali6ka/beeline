package kg.edu.iaau.beeline.controller;

import kg.edu.iaau.beeline.entity.Person;
import kg.edu.iaau.beeline.entity.dto.PersonDTO;
import kg.edu.iaau.beeline.other.CustomResponse;
import kg.edu.iaau.beeline.service.PersonService;
import kg.edu.iaau.beeline.transfer.Groups;
import kg.edu.iaau.beeline.transfer.View;
import kg.edu.iaau.beeline.util.ResponseUtil;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class PersonController
{
    @Autowired
    private PersonService personService;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private ResponseUtil responseUtil;

    @GetMapping
    public ResponseEntity getPosts(Principal principal)
    {
        if(!personService.isAdmin(principal.getName()))
        {
            return responseUtil.responseBuilder("ERROR",
                    "notAllowed", HttpStatus.METHOD_NOT_ALLOWED);
        }

        List<Person> personList = personService.getAll();
        List<PersonDTO> personDTOList = personList.stream()
                .map(person -> mapper.map(person, PersonDTO.class))
                .collect(Collectors.toList());

        return responseUtil.responseBuilder("SUCCESS",
                "getUser", personDTOList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity create(Principal principal, @Validated(Groups.New.class)
                                            @RequestBody PersonDTO personDTO)
    {
        if(!personService.isAdmin(principal.getName()))
        {
            return responseUtil.responseBuilder("ERROR",
                    "notAllowed", HttpStatus.METHOD_NOT_ALLOWED);
        }

        Person person = mapper.map(personDTO, Person.class);
        person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));

        Person personCreated = personService.save(person);
        PersonDTO dto = mapper.map(personCreated, PersonDTO.class);

        return responseUtil.responseBuilder("SUCCESS",
                "postUser", dto, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePerson( Principal principal,
                                        @PathVariable int id,
                                        @Validated(Groups.Update.class)
                                        @RequestBody PersonDTO personDTO)
    {
        if(!personService.isAdmin(principal.getName()))
        {
            return responseUtil.responseBuilder("ERROR",
                    "notAllowed", HttpStatus.METHOD_NOT_ALLOWED);
        }

        Person person = personService.getById(id);
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        mapper.map(personDTO,person);

        personService.save(person);

        personDTO = mapper.map(person, PersonDTO.class);

        return responseUtil.responseBuilder("SUCCESS",
                "infoUpdated", personDTO , HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable int id, Principal principal)
    {
        if(!personService.isAdmin(principal.getName()))
        {
            return responseUtil.responseBuilder("ERROR",
                    "notAllowed", HttpStatus.METHOD_NOT_ALLOWED);
        }

        Person person = personService.getById(id);
        personService.delete(person);

        return responseUtil.responseBuilder("SUCCESS",
                "deleteUser", HttpStatus.OK);
    }
}
