package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationEditDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EducationManager implements EducationService {

    private final EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public DataResult<List<EducationEditDto>> getByResume_Id(int resumeId) {
        List<EducationEditDto> educationEditDtoList = new ArrayList<>();
        for(Education education : this.educationDao.getByResume_Id(resumeId)) {
            EducationEditDto educationEditDto = new EducationEditDto();
            educationEditDto.setId(education.getId());
            educationEditDto.setName(education.getName());
            educationEditDto.setDepartment(education.getDepartment());
            educationEditDto.setStartDate(education.getStartDate());
            educationEditDto.setFinishDate(education.getFinishDate());
            educationEditDtoList.add(educationEditDto);
        }

        return new SuccessDataResult<>(educationEditDtoList, "Educations of Resume listed");
    }
}
