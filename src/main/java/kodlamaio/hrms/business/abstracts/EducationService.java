package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Education;
import java.util.List;

public interface EducationService {
    DataResult<List<Education>> getByResume_Id(int resumeId);
}
