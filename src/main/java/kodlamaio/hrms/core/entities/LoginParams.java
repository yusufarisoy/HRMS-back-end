package kodlamaio.hrms.core.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginParams {
    private String email;
    private String password;
}
