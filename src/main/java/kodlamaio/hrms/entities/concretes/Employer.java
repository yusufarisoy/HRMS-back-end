package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers")
public class Employer implements User {
    @Id
    @Column(name="employer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    @Column(name="firm_name")
    private String name;

    @Email
    @NotNull
    @NotBlank
    @Column(name="firm_mail")
    private String mail;

    @NotNull
    @NotBlank
    @Column(name="phone_number")
    private String phone;

    @NotNull
    @NotBlank
    @Column(name="employer_password")
    private String password;

    @NotNull
    @NotBlank
    @Column(name = "confirmation_status")
    private int confirmationStatus;
    //0 - waiting for system staff confirmation
    //1 - confirmed by system staff
    //-1 - rejected by system staff

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<Position> positions;
}
