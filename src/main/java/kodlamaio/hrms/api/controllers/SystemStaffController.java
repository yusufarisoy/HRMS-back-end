package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SystemStaffService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemStaff;
import kodlamaio.hrms.entities.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/system-staff")
public class SystemStaffController {

    private final SystemStaffService staffService;

    @Autowired
    public SystemStaffController(SystemStaffService staffService) {
        this.staffService = staffService;
    }

    @PostMapping("/add")//Will be added by system admin
    public Result add(@RequestBody SystemStaffDto systemStaffDto) {
        return this.staffService.add(systemStaffDto);
    }

    @PostMapping("/login")
    public DataResult<SystemStaff> logInWithEmailAndPassword(@RequestBody SystemStaffLoginDto loginParams) {
        return this.staffService.logInWithEmailAndPassword(loginParams);
    }

    @PostMapping("/confirm/employer")
    public Result confirmEmployerRegister(@RequestBody SystemStaffConfirmationEmployerDto confirmParams) {
        return this.staffService.confirmEmployerRegister(confirmParams);
    }

    @PostMapping("/confirm/job-advertisement")
    public Result approveJobAdvertisement(@RequestBody SystemStaffConfirmationJobAdvertisementDto confirmParams) {
        return this.staffService.approveJobAdvertisement(confirmParams);
    }

    @PostMapping("/confirm/employer/information-update")
    public Result confirmEmployerInformationUpdate(@RequestBody SystemStaffConfirmationEmployerInformationUpdateDto confirmationParams) {
        return this.staffService.confirmEmployerInformationUpdate(confirmationParams);
    }

    @PostMapping("/profile/edit")
    public Result updateInformation(@RequestBody SystemStaffInformationUpdateDto informationUpdateDto) {
        return this.staffService.updateInformation(informationUpdateDto);
    }
}
