package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.ConfirmationService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployerManager implements EmployerService
{
    private final EmployerDao employerDao;
    private final ConfirmationService confirmationService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, ConfirmationService confirmationService) {
        super();
        this.employerDao = employerDao;
        this.confirmationService = confirmationService;
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<>(this.employerDao.findAll(), "Employer list returned successfully");
    }

    @Override
    public Result add(Employer employer, String passwordRepeat) {
        if(employer.getPassword().equals(passwordRepeat)) {
            List<Employer> employers = this.employerDao.findAll();
            for(Employer emp : employers) {
                if(emp.getMail().equals(employer.getMail())) {
                    return new ErrorResult("Account already exists!");
                }
            }

            this.confirmationService.sendConfirmation(employer.getMail());

            this.employerDao.save(employer);
            return new SuccessResult("Employer registered successfully - confirmation mail send, please confirm your email and wait for system staff to confirm your information!");
        }

        return new ErrorResult("Please provide valid data!");
    }
}
