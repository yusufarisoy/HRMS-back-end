package kodlamaio.hrms.core.utilities;

import kodlamaio.hrms.core.abstracts.VerificationService;
import kodlamaio.hrms.entities.concretes.Employee;

public class Utils {

    public static boolean runVerificationServices(VerificationService[] verificationServices, Employee employee) {
        for(VerificationService service : verificationServices) {
            if(!service.verifyUser(employee)) {
                return false;
            }
        }

        return true;
    }
}
