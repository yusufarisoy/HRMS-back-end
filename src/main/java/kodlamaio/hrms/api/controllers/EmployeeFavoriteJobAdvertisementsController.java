package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployeeFavoriteJobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.EmployeeFavoriteJobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/employee-favorite-job-advertisements")
public class EmployeeFavoriteJobAdvertisementsController {

    private final EmployeeFavoriteJobAdvertisementService favoritesService;

    @Autowired
    public EmployeeFavoriteJobAdvertisementsController(EmployeeFavoriteJobAdvertisementService favoritesService) {
        this.favoritesService = favoritesService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody EmployeeFavoriteJobAdvertisementDto favoriteDto) {
        return this.favoritesService.add(favoriteDto);
    }
}
