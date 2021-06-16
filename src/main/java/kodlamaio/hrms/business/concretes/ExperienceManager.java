package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ExperienceManager implements ExperienceService {

    private final ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao) {
        this.experienceDao = experienceDao;
    }

    @Override
    public DataResult<List<Experience>> getByResume_Id(int resumeId) {
        return new SuccessDataResult<>(this.experienceDao.getByResume_Id(resumeId), "Experiences of resume listed");
    }
}
