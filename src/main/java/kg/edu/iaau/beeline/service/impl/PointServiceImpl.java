package kg.edu.iaau.beeline.service.impl;

import kg.edu.iaau.beeline.entity.Company;
import kg.edu.iaau.beeline.entity.Person;
import kg.edu.iaau.beeline.entity.Point;
import kg.edu.iaau.beeline.repository.PointDAO;
import kg.edu.iaau.beeline.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pointService")
public class PointServiceImpl implements PointService
{
    @Autowired
    private PointDAO pointDAO;

    @Override
    public Point getById(int id)
    {
        return pointDAO.getOne(id);
    }

    @Override
    public List<Point> getAll()
    {
        return pointDAO.findAll();
    }

    @Override
    public List<Point> getByCompany(Company company)
    {
        return pointDAO.getAllByCompany(company);
    }

    @Override
    public List<Point> getByUser(Person person)
    {
        return pointDAO.getAllByPerson(person);
    }

    @Override
    public List<Point> getByUserAndCompany(Person person, Company company)
    {
        return pointDAO.getAllByPersonAndCompany(person, company);
    }

    @Override
    public Point save(Point point)
    {
        return pointDAO.saveAndFlush(point);
    }

    @Override
    public void delete(Point point)
    {
        pointDAO.delete(point);
    }
}
