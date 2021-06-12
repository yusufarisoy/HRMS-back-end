package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemStaff;

public interface SystemStaffService {
    Result add(SystemStaff systemStaff);
    DataResult<SystemStaff> logInWithEmailAndPassword(String email, String password);
    Result confirmEmployerRegister(int staffId, int confirmationCode, int employerId);
}
