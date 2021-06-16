package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/job-advertisements")
public class JobAdvertisementController {

    private final JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService) {
        super();
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisementDto jobAdvertisementDto) {
        return this.jobAdvertisementService.add(jobAdvertisementDto);
    }

    @GetMapping("/get-by-status")
    public DataResult<List<JobAdvertisement>> getByStatus(@RequestParam boolean status, @RequestParam boolean approvalStatus) {
        return this.jobAdvertisementService.getByStatusAndApprovalStatus(status, approvalStatus);
    }

    @GetMapping("/get-by-status-and-releaseDate")
    public DataResult<List<JobAdvertisement>> getByStatusAndReleaseDate(@RequestParam boolean status, @RequestParam LocalDate releaseDate) {
        return this.jobAdvertisementService.getByStatusAndReleaseDate(status, releaseDate);
    }

    @GetMapping("/get-by-status-and-employer")
    public DataResult<List<JobAdvertisement>> getByStatusAndEmployer(@RequestParam boolean status, @RequestParam int employerId) {
        return this.jobAdvertisementService.getByStatusAndEmployer(status, employerId);
    }

    @GetMapping("/close-job-advertisement")
    public Result closeJobAdvertisement(@RequestParam int jobAdvertisementId) {
        return this.jobAdvertisementService.closeJobAdvertisement(jobAdvertisementId);
    }
}
