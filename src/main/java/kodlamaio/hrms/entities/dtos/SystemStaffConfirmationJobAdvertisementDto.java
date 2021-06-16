package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SystemStaffConfirmationJobAdvertisementDto {
    private int staffId;
    private boolean approvalStatus;
    private int jobAdvertisementId;
}
