package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.dtos.TechnologyEditDto;
import java.util.List;

public interface TechnologyService {
    DataResult<List<TechnologyEditDto>> getByResume_Id(int resumeId);
}
