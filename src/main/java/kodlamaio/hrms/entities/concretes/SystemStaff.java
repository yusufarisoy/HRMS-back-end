package kodlamaio.hrms.entities.concretes;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="system_staff")
public class SystemStaff implements User {
    //HRMS Personnel
    @Id
    @Column(name="system_staff_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    @Column(name="system_staff_name")
    private String name;

    @Email
    @NotNull
    @NotBlank
    @Column(name="system_staff_mail")
    private String mail;

    @NotNull
    @NotBlank
    @Column(name="system_staff_password")
    private String password;

    @NotNull
    @NotBlank
    @Column(name="phone_number")
    private String phone;
}
