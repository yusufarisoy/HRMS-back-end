package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.dtos.EducationEditDto;
import java.util.List;

public interface EducationService {
    DataResult<List<EducationEditDto>> getByResume_Id(int resumeId);
}
