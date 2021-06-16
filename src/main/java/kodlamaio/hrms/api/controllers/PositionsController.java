package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Position;
import kodlamaio.hrms.entities.dtos.PositionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/positions")
public class PositionsController
{
    private final PositionService positionService;

    @Autowired
    public PositionsController(PositionService positionService) {
        this.positionService = positionService;
    }

    @GetMapping("/get-all")
    public DataResult<List<Position>> getAll() {
        return this.positionService.getAll();
    }

    @GetMapping("/get-by-employer-id")
    public DataResult<List<Position>> getByEmployer_Id(@RequestParam int employerId) {
        return this.positionService.getByEmployer_Id(employerId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody PositionDto positionDto) {
        return this.positionService.add(positionDto);
    }
}
