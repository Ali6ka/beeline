package kg.edu.iaau.core.service;

import kg.edu.iaau.core.entity.Company;

import java.util.List;

public interface CompanyService
{
    Company getById(int id);

    List<Company> getAll();

    Company save(Company company);

    void delete(Company company);
}
