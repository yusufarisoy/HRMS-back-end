package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobTimeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTimeDao;
import kodlamaio.hrms.entities.concretes.JobTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class JobTimeManager implements JobTimeService {

    private final JobTimeDao jobTimeDao;

    @Autowired
    public JobTimeManager(JobTimeDao jobTimeDao) {
        super();
        this.jobTimeDao = jobTimeDao;
    }

    @Override
    public DataResult<List<JobTime>> getAllByJobAdvertisement_Id(int jobAdvertisementId) {
        return new SuccessDataResult<>(this.jobTimeDao.getByJobAdvertisement_Id(jobAdvertisementId), "All times of job advertisement listed.");
    }
}
