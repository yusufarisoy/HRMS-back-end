package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeDto;
import kodlamaio.hrms.entities.dtos.ResumeEditDto;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public interface ResumeService {
    Result add(ResumeDto resumeDto);

    Result edit(ResumeEditDto resumeEditDto);

    Result upload(int resumeId, MultipartFile multipartFile);

    DataResult<Resume> getById(int id);

    DataResult<List<Resume>> getAllSortedByGraduationDate();

    DataResult<List<Resume>> getAllSortedByExperienceYear();

    DataResult<List<Resume>> getByEmployee_Id(int employerId);
}
