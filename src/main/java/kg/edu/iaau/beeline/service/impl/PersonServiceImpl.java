package kg.edu.iaau.beeline.service.impl;

import kg.edu.iaau.beeline.entity.Person;
import kg.edu.iaau.beeline.repository.PersonDAO;
import kg.edu.iaau.beeline.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("personService")
public class PersonServiceImpl implements PersonService
{
    @Autowired
    private PersonDAO personDAO;

    @Override
    @Transactional(readOnly = true)
    public Person getById(int id)
    {
        return personDAO.getOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> getAll()
    {
        return personDAO.findAll();
    }

    @Override
    @Transactional
    public Person save(Person person)
    {
        return personDAO.saveAndFlush(person);
    }

    @Override
    @Transactional
    public void delete(Person person)
    {
        personDAO.delete(person);
    }
}
