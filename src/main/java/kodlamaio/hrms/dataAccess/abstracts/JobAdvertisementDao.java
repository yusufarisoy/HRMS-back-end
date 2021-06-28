package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> getByStatusAndApprovalStatus(boolean status, int approvalStatus, Pageable pageable);

    List<JobAdvertisement> getByStatusAndReleaseDate(boolean status, LocalDate releaseDate);

    List<JobAdvertisement> getByStatusAndPosition_Employer_Id(boolean status, int employerId);

    //Filters
    List<JobAdvertisement> getByStatusAndApprovalStatusAndCityAndJobTime_Name(boolean status, int approvalStatus, String city, String jobTimeName);
    List<JobAdvertisement> getByStatusAndApprovalStatusAndCity(boolean status, int approvalStatus, String city);
    List<JobAdvertisement> getByStatusAndApprovalStatusAndJobTime_Name(boolean status, int approvalStatus, String jobTimeName);
}
