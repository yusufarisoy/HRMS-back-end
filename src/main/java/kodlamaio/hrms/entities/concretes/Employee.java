package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.hrms.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employees")
public class Employee implements User {
    @Id
    @Column(name="employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "position_id")
    private Position position;

    @NotNull
    @NotBlank
    @Column(name="nationality_id")
    private String nationalityId;

    @Email
    @NotNull
    @NotBlank
    @Column(name="employee_mail")
    private String mail;

    @NotNull
    @NotBlank
    @Column(name="employee_password")
    private String password;

    @NotNull
    @NotBlank
    @Column(name="employee_name")
    private String name;

    @NotNull
    @NotBlank
    @Column(name="employee_surname")
    private String surname;

    @NotNull
    @NotBlank
    @Column(name="employee_date_of_birth")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @JsonIgnore
    @OneToMany(mappedBy = "employee")
    private List<Resume> resumes;
}
