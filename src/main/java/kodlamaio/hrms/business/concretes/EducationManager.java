package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EducationManager implements EducationService {

    private final EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public DataResult<List<Education>> getByResume_Id(int resumeId) {
        //Todo implement dto lists
        /*List<EducationDto> educationDtoList = new ArrayList<>();

        for(Education education : this.educationDao.getByResume_Id(resumeId)) {
            EducationDto educationDto = new EducationDto();
            educationDto.setName(education.getName());
            educationDto.setDepartment(education.getDepartment());
            educationDto.setStartDate(education.getStartDate());
            educationDto.setFinishDate(education.getFinishDate());
            educationDtoList.add(educationDto);
        }*/
        return new SuccessDataResult<>(this.educationDao.getByResume_Id(resumeId), "Educations of Resume listed");
    }
}
