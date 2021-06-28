package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerInformationUpdate;
import kodlamaio.hrms.entities.dtos.EmployerInformationUpdateDto;
import java.util.List;

public interface EmployerInformationUpdateService {
    DataResult<EmployerInformationUpdate> getWaitingUpdateByEmployer_Id(int employerId);
    DataResult<List<EmployerInformationUpdate>> getByEmployer_Id(int employerId);
    DataResult<List<EmployerInformationUpdate>> getAll();
    Result add(EmployerInformationUpdateDto employerInformationUpdateDto);
}
