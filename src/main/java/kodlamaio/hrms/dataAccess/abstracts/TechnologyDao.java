package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TechnologyDao extends JpaRepository<Technology, Integer> {
    List<Technology> getByResume_Id(int resumeId);
}
