package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PositionDao extends JpaRepository<Position, Integer> {
    List<Position> getByEmployer_Id(int employerId);
}
