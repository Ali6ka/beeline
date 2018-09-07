package kg.edu.iaau.beeline.repository;

import kg.edu.iaau.beeline.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends JpaRepository<Person, Integer>
{
    Person findByUsername(String username);
}