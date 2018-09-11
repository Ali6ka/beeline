package kg.edu.iaau.core.repository;

import kg.edu.iaau.core.entity.Company;
import kg.edu.iaau.core.entity.Person;
import kg.edu.iaau.core.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointDAO extends JpaRepository<Point, Integer>
{
    List<Point> getAllByCompanyOrderById(Company company);

    List<Point> getAllByPersonOrderById(Person person);

    List<Point> getAllByPersonAndCompanyOrderById(Person person, Company company);
}
