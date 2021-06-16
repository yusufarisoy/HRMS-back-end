package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> getByStatusAndApprovalStatus(boolean status, boolean approvalStatus);

    List<JobAdvertisement> getByStatusAndReleaseDate(boolean status, LocalDate releaseDate);

    List<JobAdvertisement> getByStatusAndPosition_Employer_Id(boolean status, int employerId);
}
