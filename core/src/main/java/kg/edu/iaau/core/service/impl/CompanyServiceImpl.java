package kg.edu.iaau.core.service.impl;

import kg.edu.iaau.core.entity.Company;
import kg.edu.iaau.core.repository.CompanyDAO;
import kg.edu.iaau.core.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        return companyDAO.findAll(Sort.by(Sort.Direction.ASC, "id"));
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
