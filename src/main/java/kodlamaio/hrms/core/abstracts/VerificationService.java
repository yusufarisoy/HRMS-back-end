package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.entities.concretes.Employee;
import kodlamaio.hrms.entities.concretes.Employer;

public interface VerificationService {
    boolean verifyUser(Employee employee);
}
