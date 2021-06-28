package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemStaff;
import kodlamaio.hrms.entities.dtos.*;

public interface SystemStaffService {
    Result add(SystemStaffDto systemStaff);
    DataResult<SystemStaff> logInWithEmailAndPassword(SystemStaffLoginDto loginParams);
    Result confirmEmployerRegister(SystemStaffConfirmationEmployerDto confirmationParams);
    Result approveJobAdvertisement(SystemStaffConfirmationJobAdvertisementDto confirmationParams);
    Result confirmEmployerInformationUpdate(SystemStaffConfirmationEmployerInformationUpdateDto confirmationParams);

    Result updateInformation(SystemStaffInformationUpdateDto informationUpdateDto);
}
