package kg.edu.iaau.beeline.repository;

import kg.edu.iaau.beeline.entity.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointDAO extends JpaRepository<Point, Integer>
{
}
