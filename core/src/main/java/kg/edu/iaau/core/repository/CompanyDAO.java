package kg.edu.iaau.core.repository;

import kg.edu.iaau.core.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyDAO extends JpaRepository<Company, Integer>
{
}
