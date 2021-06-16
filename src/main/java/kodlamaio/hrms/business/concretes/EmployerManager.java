package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.abstracts.ConfirmationService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.dtos.EmployerDto;
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
    public Result add(EmployerDto employerDto) {
        if(employerDto.getPassword().equals(employerDto.getPasswordRepeat())) {
            List<Employer> employers = this.employerDao.findAll();
            for(Employer emp : employers) {
                if(emp.getMail().equals(employerDto.getMail())) {
                    return new ErrorResult("Account already exists!");
                }
            }

            Employer employer = new Employer();
            employer.setName(employerDto.getName());
            employer.setMail(employerDto.getMail());
            employer.setPhone(employerDto.getPhone());
            employer.setPassword(employerDto.getPassword());
            employer.setConfirmationStatus(0);
            this.employerDao.save(employer);

            this.confirmationService.sendConfirmation(employer.getMail());
            return new SuccessResult("Employer registered successfully - confirmation mail send, please confirm your email and wait for system staff to confirm your information!");
        }

        return new ErrorResult("Please provide valid data!");
    }
}
