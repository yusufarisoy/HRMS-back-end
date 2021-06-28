package kodlamaio.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "job_advertisements")
public class JobAdvertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_advertisement_id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "position_id")
    private Position position;

    @Column(name = "approval_status")
    private int approvalStatus;
    /*
    * 0 - waiting for approval
    * 1 - approved
    * -1 - rejected
    * */

    @Column(name = "job_advertisement_status")
    private boolean status;//Active or Passive

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "job_advertisement_description")
    private String description;

    @Column(name = "job_advertisement_city")
    private String city;

    @Column(name = "minimum_salary")
    private double minSalary;

    @Column(name = "maximum_salary")
    private double maxSalary;

    @Column(name = "position_count")
    private int positionCount;

    @Column(name = "work_style")
    private String workStyle;//Remote or not

    @JsonIgnore
    @OneToOne(mappedBy = "jobAdvertisement")
    private JobTime jobTime;

    @Column(name = "last_apply_date")
    private Date lastApplyDate;
}
