package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobTimeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.JobTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/job-times")
public class JobTimeController {

    private final JobTimeService jobTimeService;

    @Autowired
    public JobTimeController(JobTimeService jobTimeService) {
        this.jobTimeService = jobTimeService;
    }

    @GetMapping("/get-by-job-advertisement-id")
    public DataResult<List<JobTime>> getAllByJobAdvertisement_Id(@RequestParam int jobAdvertisementId) {
        return this.jobTimeService.getAllByJobAdvertisement_Id(jobAdvertisementId);
    }
}
