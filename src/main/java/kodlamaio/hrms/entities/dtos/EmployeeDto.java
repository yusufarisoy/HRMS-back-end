package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private String nationalityId;
    private String mail;
    private String password;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String passwordRepeat;
}
