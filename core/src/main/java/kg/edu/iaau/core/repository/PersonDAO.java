package kg.edu.iaau.core.repository;

import kg.edu.iaau.core.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDAO extends JpaRepository<Person, Integer>
{
    Person findByUsername(String username);
}