package kodlamaio.hrms.Mernis;

import java.util.Date;

public class MernisManager {
    public boolean verifyUser(String nationalityId, String name, String surname, Date dateOfBirth) {
        return nationalityId.length() == 11 && name.length() > 3 && surname.length() > 3;
    }
}
