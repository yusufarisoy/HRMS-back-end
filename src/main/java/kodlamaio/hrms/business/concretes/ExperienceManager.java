package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;
import kodlamaio.hrms.entities.dtos.ExperienceEditDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExperienceManager implements ExperienceService {

    private final ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao) {
        this.experienceDao = experienceDao;
    }

    @Override
    public DataResult<List<ExperienceEditDto>> getByResume_Id(int resumeId) {
        List<ExperienceEditDto> experienceEditDtoList = new ArrayList<>();
        for(Experience experience : this.experienceDao.getByResume_Id(resumeId)) {
            ExperienceEditDto experienceEditDto = new ExperienceEditDto();
            experienceEditDto.setId(experience.getId());
            experienceEditDto.setName(experience.getName());
            experienceEditDto.setDepartment(experience.getDepartment());
            experienceEditDto.setStartDate(experience.getStartDate());
            experienceEditDto.setFinishDate(experience.getFinishDate());
            experienceEditDtoList.add(experienceEditDto);
        }

        return new SuccessDataResult<>(experienceEditDtoList, "Experiences of resume listed");
    }
}
