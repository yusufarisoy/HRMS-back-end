package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.dtos.LanguageEditDto;
import java.util.List;

public interface LanguageService {
    DataResult<List<LanguageEditDto>> getByResume_Id(int resumeId);
}
