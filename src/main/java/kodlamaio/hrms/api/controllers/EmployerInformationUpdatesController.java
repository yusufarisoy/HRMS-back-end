package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployerInformationUpdateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.EmployerInformationUpdate;
import kodlamaio.hrms.entities.dtos.EmployerInformationUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/employer-information-updates")
public class EmployerInformationUpdatesController {

    private final EmployerInformationUpdateService informationUpdateService;

    @Autowired
    public EmployerInformationUpdatesController(EmployerInformationUpdateService informationUpdateService) {
        this.informationUpdateService = informationUpdateService;
    }

    @GetMapping("/get-by-employer-id")
    public DataResult<List<EmployerInformationUpdate>> getByEmployer_Id(int employerId) {
        return this.informationUpdateService.getByEmployer_Id(employerId);
    }

    @GetMapping("/get-waiting-update-by-employer-id")
    public DataResult<EmployerInformationUpdate> getWaitingUpdateByEmployer_Id(int employerId) {
        return this.informationUpdateService.getWaitingUpdateByEmployer_Id(employerId);
    }

    @GetMapping("/get-all")
    public DataResult<List<EmployerInformationUpdate>> getAll() {
        return this.informationUpdateService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody EmployerInformationUpdateDto employerInformationUpdateDto) {
        return this.informationUpdateService.add(employerInformationUpdateDto);
    }
}
