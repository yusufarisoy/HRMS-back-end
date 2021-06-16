package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="resumes")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "educations" })
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="resume_id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name="photo_url")
    private String photoUrl;

    @Column(name="github_url")
    private String githubUrl;

    @Column(name="linkedin_url")
    private String linkedInUrl;

    @Column(name="resume_description")
    private String description;

    @OneToMany(mappedBy = "resume")
    private List<Education> educations;

    @JsonIgnore
    @OneToMany(mappedBy = "resume")
    private List<Experience> experiences;

    @JsonIgnore
    @OneToMany(mappedBy = "resume")
    private List<Language> languages;

    @JsonIgnore
    @OneToMany(mappedBy = "resume")
    private List<Technology> technologies;
}
