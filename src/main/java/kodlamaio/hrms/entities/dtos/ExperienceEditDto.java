package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExperienceEditDto {
    private int id;
    private String name;
    private String department;
    private Date startDate;
    private Date finishDate;
}
