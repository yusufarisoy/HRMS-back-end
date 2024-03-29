package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.dtos.ExperienceEditDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/experiences")
public class ExperiencesController {

    private final ExperienceService experienceService;

    @Autowired
    public ExperiencesController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/get-by-resume-id")
    public DataResult<List<ExperienceEditDto>> getByResume_Id(int resumeId) {
        return this.experienceService.getByResume_Id(resumeId);
    }
}
