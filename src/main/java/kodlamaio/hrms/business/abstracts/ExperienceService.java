package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Experience;
import java.util.List;

public interface ExperienceService {
    DataResult<List<Experience>> getByResume_Id(int resumeId);
}
