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
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "employees" })
public class Employer implements User
{
    @Id
    @Column(name="id")
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
    @Column(name="password")
    private String password;

    @OneToMany(mappedBy = "employer")
    private List<Employee> employees;

    @JsonIgnore
    @OneToMany(mappedBy = "employer")
    private List<Position> positions;
}
