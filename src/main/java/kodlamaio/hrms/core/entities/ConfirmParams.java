package kodlamaio.hrms.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConfirmParams {
    private int staffId;
    private int confirmationCode;
    private int employerId;
}
