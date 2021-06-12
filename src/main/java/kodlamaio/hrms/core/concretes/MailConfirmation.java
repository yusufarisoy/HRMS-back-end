package kodlamaio.hrms.core.concretes;

import kodlamaio.hrms.core.abstracts.ConfirmationService;
import org.springframework.stereotype.Service;

@Service
public class MailConfirmation implements ConfirmationService {
    @Override
    public void sendConfirmation(String mailAddress) {
        System.out.println("Confirmation mail send to " + mailAddress);
    }
}
