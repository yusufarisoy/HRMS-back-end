package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/technologies")
public class TechnologiesController {

    private final TechnologyService technologyService;

    @Autowired
    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/get-by-resume-id")
    public DataResult<List<Technology>> getByResume_Id(int resumeId) {
        return this.technologyService.getByResume_Id(resumeId);
    }
}
