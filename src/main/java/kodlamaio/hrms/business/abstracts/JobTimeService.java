package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobTime;
import java.util.List;

public interface JobTimeService {
    DataResult<List<JobTime>> getAllByJobAdvertisement_Id(int jobAdvertisementId);
}
