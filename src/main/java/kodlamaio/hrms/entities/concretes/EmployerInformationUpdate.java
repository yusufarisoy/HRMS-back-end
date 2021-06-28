package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employers_information_updates")
public class EmployerInformationUpdate {
    @Id
    @Column(name="update_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

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
    /* -1 - rejected
    * 0 - waiting confirmation from system staff
    * 1 - approved */

    @Column(name = "update_date")
    private Date updateDate;
}
