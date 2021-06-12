package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SystemStaffService;
import kodlamaio.hrms.core.entities.ConfirmParams;
import kodlamaio.hrms.core.entities.LoginParams;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.SystemStaff;
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

    @PostMapping("/add")
    public Result add(@RequestBody SystemStaff systemStaff) {
        return this.staffService.add(systemStaff);
    }

    @PostMapping("/login")
    DataResult<SystemStaff> logInWithEmailAndPassword(@RequestBody LoginParams loginParams) {
        return this.staffService.logInWithEmailAndPassword(loginParams.getEmail(), loginParams.getPassword());
    }

    @PostMapping("/confirm")
    Result confirmEmployerRegister(@RequestBody ConfirmParams confirmParams) {
        return this.staffService.confirmEmployerRegister(confirmParams.getStaffId(), confirmParams.getConfirmationCode(), confirmParams.getEmployerId());
    }
}
