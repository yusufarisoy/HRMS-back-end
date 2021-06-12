package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="educations")
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="education_id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "resume_id")
    private Resume resume;

    @NotNull
    @NotBlank
    @Column(name="education_name")
    private String name;

    @NotNull
    @NotBlank
    @Column(name="education_department")
    private String department;

    @NotNull
    @NotBlank
    @Column(name="education_start_date")
    private Date startDate;

    @Column(name="education_finish_date")
    private Date finishDate;
}
