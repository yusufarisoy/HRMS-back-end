package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="positions")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "employees" })
public class Position
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="position_id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @Column(name="position_name")
    private String name;

    @OneToMany(mappedBy = "position")
    private List<Employee> employees;

    @JsonIgnore
    @OneToMany(mappedBy = "position")
    private List<JobAdvertisement> jobAdvertisements;
}
