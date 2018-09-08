package kg.edu.iaau.beeline.service.impl;

import kg.edu.iaau.beeline.entity.Company;
import kg.edu.iaau.beeline.repository.CompanyDAO;
import kg.edu.iaau.beeline.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("companyService")
public class CompanyServiceImpl implements CompanyService
{
    @Autowired
    private CompanyDAO companyDAO;

    @Override
    @Transactional(readOnly = true)
    public Company getById(int id)
    {
        return companyDAO.getOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Company> getAll()
    {
        return companyDAO.findAll();
    }

    @Override
    @Transactional
    public Company save(Company company)
    {
        return companyDAO.saveAndFlush(company);
    }

    @Override
    @Transactional
    public void delete(Company company)
    {
        companyDAO.delete(company);
    }
}
