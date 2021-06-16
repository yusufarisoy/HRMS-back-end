package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/educations")
public class EducationsController {

    private final EducationService educationService;

    @Autowired
    public EducationsController(EducationService educationService) {
        this.educationService = educationService;
    }

    @GetMapping("/get-by-resume-id")
    public DataResult<List<Education>> getByResume_Id(int resumeId) {
        return this.educationService.getByResume_Id(resumeId);
    }
}
