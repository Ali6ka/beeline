package kg.edu.iaau.core.service.impl;

import kg.edu.iaau.core.entity.Company;
import kg.edu.iaau.core.entity.Person;
import kg.edu.iaau.core.entity.Point;
import kg.edu.iaau.core.repository.PointDAO;
import kg.edu.iaau.core.service.PointService;
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
        return pointDAO.getAllByCompanyOrderById(company);
    }

    @Override
    public List<Point> getByUser(Person person)
    {
        return pointDAO.getAllByPersonOrderById(person);
    }

    @Override
    public List<Point> getByUserAndCompany(Person person, Company company)
    {
        return pointDAO.getAllByPersonAndCompanyOrderById(person, company);
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
