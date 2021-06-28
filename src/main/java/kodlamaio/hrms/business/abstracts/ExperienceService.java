package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.dtos.ExperienceEditDto;
import java.util.List;

public interface ExperienceService {
    DataResult<List<ExperienceEditDto>> getByResume_Id(int resumeId);
}
