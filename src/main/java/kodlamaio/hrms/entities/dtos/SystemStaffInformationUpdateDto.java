package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemStaffInformationUpdateDto {
    private int id;
    private String name;
    private String mail;
    private String phone;
    private String password;
}
