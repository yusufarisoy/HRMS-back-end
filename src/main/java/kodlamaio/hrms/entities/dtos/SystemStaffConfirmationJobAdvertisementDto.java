package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SystemStaffConfirmationJobAdvertisementDto {
    private int staffId;
    private int approvalStatus;
    private int jobAdvertisementId;
}
