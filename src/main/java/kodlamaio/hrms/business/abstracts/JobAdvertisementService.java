package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

import java.time.LocalDate;
import java.util.List;

public interface JobAdvertisementService {
    Result add(JobAdvertisementDto jobAdvertisementDto);

    DataResult<List<JobAdvertisement>> getByStatusAndApprovalStatus(boolean status, int approvalStatus, int page, int pageSize);

    DataResult<List<JobAdvertisement>> getByStatusAndReleaseDate(boolean status, LocalDate releaseDate);

    DataResult<List<JobAdvertisement>> getByStatusAndEmployer(boolean status, int employerId);

    Result closeJobAdvertisement(int jobAdvertisementId);

    DataResult<List<JobAdvertisement>> getByStatusAndCityAndJobTime_Name(boolean status, String city, String jobTimeName);
    DataResult<List<JobAdvertisement>> getByStatusAndCity(boolean status, String city);
    DataResult<List<JobAdvertisement>> getByStatusAndJobTime_Name(boolean status, String jobTimeName);
}
