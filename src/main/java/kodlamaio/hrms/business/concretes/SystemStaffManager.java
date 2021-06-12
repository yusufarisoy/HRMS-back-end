package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SystemStaffService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.SystemStaffDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.SystemStaff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SystemStaffManager implements SystemStaffService {

    private final SystemStaffDao systemStaffDao;
    private final EmployerDao employerDao;

    @Autowired
    public SystemStaffManager(SystemStaffDao systemStaffDao, EmployerDao employerDao) {
        super();
        this.systemStaffDao = systemStaffDao;
        this.employerDao = employerDao;
    }

    @Override
    public Result add(SystemStaff newSystemStaff) {
        List<SystemStaff> staffList = this.systemStaffDao.findAll();
        for(SystemStaff staff : staffList) {
            if(staff.getMail().equals(newSystemStaff.getMail())) {
                return new ErrorResult("Personnel with mail already exists!");
            }
        }

        this.systemStaffDao.save(newSystemStaff);
        return new SuccessResult("New Staff added successfully");
    }

    @Override
    public DataResult<SystemStaff> logInWithEmailAndPassword(String email, String password) {
        List<SystemStaff> allStaff = this.systemStaffDao.findAll();
        for(SystemStaff staff : allStaff) {
            if(staff.getMail().equals(email) && staff.getPassword().equals(password)) {
                return new SuccessDataResult<>(staff, "Authenticated successfully");
            }
        }

        return new ErrorDataResult<>(null, "Incorrect email or password!");
    }

    @Override
    public Result confirmEmployerRegister(int staffId, int confirmationCode, int employerId) {
        if(this.systemStaffDao.findById(staffId).isPresent() && this.employerDao.findById(employerId).isPresent()) {
            Employer employer = this.employerDao.findById(employerId).get();
            employer.setConfirmationStatus(confirmationCode);
            this.employerDao.save(employer);

            if(confirmationCode == 1) {
                return new SuccessResult("Information of employer confirmed by system personnel with id: " + staffId);
            } else {
                //Going to be -1
                return new SuccessResult("Information of employer rejected by system personnel with id: " + staffId);
            }
        }

        return new ErrorResult("Not a valid system staff or employer");
    }
}
