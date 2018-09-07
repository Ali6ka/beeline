package kg.edu.iaau.beeline.controller;

import kg.edu.iaau.beeline.entity.Person;
import kg.edu.iaau.beeline.entity.dto.PersonDTO;
import kg.edu.iaau.beeline.other.CustomResponse;
import kg.edu.iaau.beeline.service.PersonService;
import kg.edu.iaau.beeline.transfer.TransferDTO;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping
    public ResponseEntity<CustomResponse> getPosts()
    {
        List<Person> personList = personService.getAll();
        List<PersonDTO> personDTOList = personList.stream()
                .map(person -> mapper.map(person, PersonDTO.class))
                .collect(Collectors.toList());

        return new ResponseEntity(
                new CustomResponse("SUCCESS",
                        messageSource.getMessage("getUser",new Object[0], new Locale("")),
                        personDTOList), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonDTO> create(@Validated(TransferDTO.New.class)
                                            @RequestBody PersonDTO personDTO)
    {
        Person person = mapper.map(personDTO, Person.class);
        person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));

        Person personCreated = personService.save(person);
        PersonDTO dto = mapper.map(personCreated, PersonDTO.class);

        return new ResponseEntity(
                new CustomResponse("SUCCESS",
                        messageSource.getMessage("postUser",new Object[0], new Locale("")),
                        dto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePerson(@PathVariable int id,
                                  @Validated(TransferDTO.Update.class)
                                  @RequestBody PersonDTO personDTO)
    {
        Person person = personService.getById(id);
        mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        mapper.map(personDTO,person);

        personService.save(person);

        personDTO = mapper.map(person, PersonDTO.class);

        return new ResponseEntity(
                new CustomResponse("SUCCESS",
                        messageSource.getMessage("infoUpdated",new Object[0], new Locale("")),
                        personDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable int id)
    {
        Person person = personService.getById(id);
        personService.delete(person);

        return new ResponseEntity(
                new CustomResponse("SUCCESS",
                        messageSource.getMessage("deleteUser",new Object[0], new Locale(""))),
                        HttpStatus.OK);
    }
}
