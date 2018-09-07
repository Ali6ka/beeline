package kg.edu.iaau.beeline.service;

import kg.edu.iaau.beeline.entity.Person;

import java.util.List;

public interface PersonService
{
    Person getById(int id);

    Person findByUsername(String username);

    List<Person> getAll();

    Person save(Person person);

    void delete(Person person);

    boolean isAdmin(String username);
}
