package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Position;
import kodlamaio.hrms.entities.dtos.PositionDto;

import java.util.List;

public interface PositionService {
    DataResult<List<Position>> getAll();
    DataResult<List<Position>> getByEmployer_Id(int employerId);
    Result add(PositionDto positionDto);
}
