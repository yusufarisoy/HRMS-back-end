package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemStaffConfirmationEmployerInformationUpdateDto {
    private int systemStaffId;
    private int informationUpdateId;
    private int confirmationCode;
}
