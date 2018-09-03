package kg.edu.iaau.beeline.repository;

import kg.edu.iaau.beeline.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDAO extends JpaRepository<Company, Integer>
{
}
