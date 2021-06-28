package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemStaffConfirmationEmployerDto {
    private int staffId;
    private int confirmationCode;
    private int employerId;
}
