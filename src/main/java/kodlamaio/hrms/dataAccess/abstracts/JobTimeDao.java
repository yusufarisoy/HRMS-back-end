package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobTime;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JobTimeDao extends JpaRepository<JobTime, Integer> {
    List<JobTime> getByJobAdvertisement_Id(int jobAdvertisementId);
}
