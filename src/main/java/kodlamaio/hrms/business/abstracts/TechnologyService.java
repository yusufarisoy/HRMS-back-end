package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Technology;
import java.util.List;

public interface TechnologyService {
    DataResult<List<Technology>> getByResume_Id(int resumeId);
}
