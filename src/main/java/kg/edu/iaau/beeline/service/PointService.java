package kg.edu.iaau.beeline.service;

import kg.edu.iaau.beeline.entity.Company;
import kg.edu.iaau.beeline.entity.Person;
import kg.edu.iaau.beeline.entity.Point;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface PointService
{
    Point getById(int id);

    List<Point> getAll();

    List<Point> getByCompany(Company company);

    List<Point> getByUser(Person person);

    List<Point> getByUserAndCompany(Person person, Company company);

    Point save(Point point);

    void delete(Point point);
}
