package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.dataAccess.abstracts.JobTimeDao;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.JobTime;
import kodlamaio.hrms.entities.concretes.Position;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private final JobAdvertisementDao jobAdvertisementDao;
    private final PositionDao positionDao;
    private final JobTimeDao jobTimeDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao, PositionDao positionDao, JobTimeDao jobTimeDao) {
        super();
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.positionDao = positionDao;
        this.jobTimeDao = jobTimeDao;
    }

    @Override
    public Result add(JobAdvertisementDto jobAdvertisementDto) {

        if(this.positionDao.findById(jobAdvertisementDto.getPositionId()).isPresent()) {
            JobAdvertisement jobAdvertisement = new JobAdvertisement();
            Position position = this.positionDao.findById(jobAdvertisementDto.getPositionId()).get();
            jobAdvertisement.setPosition(position);

            jobAdvertisement.setApprovalStatus(false);
            jobAdvertisement.setStatus(true);
            jobAdvertisement.setReleaseDate(new Date());
            jobAdvertisement.setDescription(jobAdvertisementDto.getDescription());
            jobAdvertisement.setCity(jobAdvertisementDto.getCity());
            jobAdvertisement.setMinSalary(jobAdvertisementDto.getMinSalary());
            jobAdvertisement.setMaxSalary(jobAdvertisementDto.getMaxSalary());
            jobAdvertisement.setPositionCount(jobAdvertisementDto.getPositionCount());
            jobAdvertisement.setWorkStyle(jobAdvertisementDto.getWorkStyle());
            jobAdvertisement.setLastApplyDate(jobAdvertisementDto.getLastApplyDate());
            this.jobAdvertisementDao.save(jobAdvertisement);

            JobTime jobTime = new JobTime();
            jobTime.setJobAdvertisement(jobAdvertisement);
            jobTime.setName(jobAdvertisementDto.getJobTimeName());
            this.jobTimeDao.save(jobTime);

            return new SuccessResult("Job advertisement added successfully");
        }

        return new ErrorResult("Not an existing Position");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusAndApprovalStatus(boolean status, boolean approvalStatus) {
        return new SuccessDataResult<>(this.jobAdvertisementDao.getByStatusAndApprovalStatus(status, approvalStatus),
                "All ads have been listed - status: " + status + " - approvalStatus: " + approvalStatus);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusAndReleaseDate(boolean status, LocalDate releaseDate) {
        return new SuccessDataResult<>(this.jobAdvertisementDao.getByStatusAndReleaseDate(status, releaseDate), "All ads have been listed according to their release date - status: " + status);
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusAndEmployer(boolean status, int employerId) {
        return new SuccessDataResult<>(this.jobAdvertisementDao.getByStatusAndPosition_Employer_Id(status, employerId), "All ads of an employer have been listed - status: " + status);
    }

    @Override
    public Result closeJobAdvertisement(int jobAdvertisementId) {
        if(this.jobAdvertisementDao.findById(jobAdvertisementId).isPresent()) {
            JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(jobAdvertisementId).get();
            jobAdvertisement.setStatus(false);
            this.jobAdvertisementDao.save(jobAdvertisement);

            return new SuccessResult("Job advertisement has closed");
        }

        return new ErrorResult("Job advertisement couldn't found");
    }
}
