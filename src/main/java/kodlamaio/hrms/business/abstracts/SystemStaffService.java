package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemStaff;
import kodlamaio.hrms.entities.dtos.SystemStaffConfirmationEmployerDto;
import kodlamaio.hrms.entities.dtos.SystemStaffConfirmationJobAdvertisementDto;
import kodlamaio.hrms.entities.dtos.SystemStaffDto;
import kodlamaio.hrms.entities.dtos.SystemStaffLoginDto;

public interface SystemStaffService {
    Result add(SystemStaffDto systemStaff);
    DataResult<SystemStaff> logInWithEmailAndPassword(SystemStaffLoginDto loginParams);
    Result confirmEmployerRegister(SystemStaffConfirmationEmployerDto confirmationParams);
    Result approveJobAdvertisement(SystemStaffConfirmationJobAdvertisementDto confirmationParams);
}
