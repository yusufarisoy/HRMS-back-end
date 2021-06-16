package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SystemStaffConfirmationEmployerDto {
    private int staffId;
    private int confirmationCode;
    private int employerId;
}
