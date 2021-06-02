package kodlamaio.hrms.entities.concretes;

import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employees")
public class Employee implements User
{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @NotNull
    @NotBlank
    @Column(name="nationality_id")
    private String nationalityId;

    @Email
    @NotNull
    @NotBlank
    @Column(name="mail")
    private String mail;

    @NotNull
    @NotBlank
    @Column(name="password")
    private String password;

    @NotNull
    @NotBlank
    @Column(name="name")
    private String name;

    @NotNull
    @NotBlank
    @Column(name="surname")
    private String surname;

    @NotNull
    @NotBlank
    @Column(name="date_of_birth")
    private Date dateOfBirth;
}
