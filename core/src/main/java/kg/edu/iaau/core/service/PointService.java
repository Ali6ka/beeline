package kg.edu.iaau.core.service;

import kg.edu.iaau.core.entity.Company;
import kg.edu.iaau.core.entity.Person;
import kg.edu.iaau.core.entity.Point;

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
