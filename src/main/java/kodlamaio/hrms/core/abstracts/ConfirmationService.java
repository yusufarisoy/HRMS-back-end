package kodlamaio.hrms.core.abstracts;

public interface ConfirmationService {
    void sendConfirmation(String confirmationAddress);
    //Confirmation address can be email and also phone number in the future
}
