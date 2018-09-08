package kg.edu.iaau.beeline.service;

import kg.edu.iaau.beeline.entity.Company;

import java.util.List;

public interface CompanyService
{
    Company getById(int id);

    List<Company> getAll();

    Company save(Company company);

    void delete(Company company);
}
