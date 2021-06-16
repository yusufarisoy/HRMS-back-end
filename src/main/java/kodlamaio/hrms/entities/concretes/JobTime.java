package kodlamaio.hrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_times")
public class JobTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_time_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "job_advertisement_id")
    private JobAdvertisement jobAdvertisement;

    @Column(name="job_time_name")
    private String name;
}
