package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployeeService;
import kodlamaio.hrms.core.abstracts.ConfirmationService;
import kodlamaio.hrms.core.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.Utils;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.dtos.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeManager implements EmployeeService
{
    private final EmployeeDao employeeDao;
    private final VerificationService[] verificationServices;
    private final ConfirmationService confirmationService;

    @Autowired
    public EmployeeManager(EmployeeDao employeeDao, VerificationService[] verificationServices, ConfirmationService confirmationService) {
        super();
        this.employeeDao = employeeDao;
        this.verificationServices = verificationServices;
        this.confirmationService = confirmationService;
    }

    @Override
    public DataResult<List<Employee>> getAll() {
        return new SuccessDataResult<>(this.employeeDao.findAll(), "Employee list returned successfully");
    }

    @Override
    public Result add(EmployeeDto employeeDto) {
        if(employeeDto.getPassword().equals(employeeDto.getPasswordRepeat())) {
            List<Employee> list = this.employeeDao.findAll();
            for(Employee emp : list) {
                if(emp.getMail().equals(employeeDto.getMail()) || emp.getNationalityId().equals(employeeDto.getNationalityId())) {
                    return new ErrorResult("Account already exists!");
                }
            }

            Employee employee = new Employee();
            employee.setNationalityId(employeeDto.getNationalityId());
            employee.setMail(employeeDto.getMail());
            employee.setPassword(employeeDto.getPassword());
            employee.setName(employeeDto.getName());
            employee.setSurname(employeeDto.getSurname());
            employee.setDateOfBirth(employeeDto.getDateOfBirth());

            if(!Utils.runVerificationServices(verificationServices, employee)) {
                return new ErrorResult("Please provide valid data!");
            }

            this.employeeDao.save(employee);

            this.confirmationService.sendConfirmation(employee.getMail());
            return new SuccessResult("Employee registered successfully - confirmation mail send, please confirm your email!");
        }

        return new ErrorResult("Passwords doesn't match!");
    }
}
