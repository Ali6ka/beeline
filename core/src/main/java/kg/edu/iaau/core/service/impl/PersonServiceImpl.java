package kg.edu.iaau.core.service.impl;

import kg.edu.iaau.core.entity.Person;
import kg.edu.iaau.core.repository.PersonDAO;
import kg.edu.iaau.core.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
    public Person findByUsername(String username)
    {
        return personDAO.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Person> getAll()
    {
        return personDAO.findAll(Sort.by(Sort.Direction.ASC, "id"));
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

    @Override
    public boolean isAdmin(String username)
    {
        return findByUsername(username).getIsAdmin();
    }
}
