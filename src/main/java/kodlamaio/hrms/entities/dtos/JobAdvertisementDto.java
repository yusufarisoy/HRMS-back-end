package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvertisementDto {
    private int positionId;
    private String description;
    private String city;
    private double minSalary;
    private double maxSalary;
    private int positionCount;
    private String workStyle;
    private Date lastApplyDate;

    private String jobTimeName;
}
