package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.EmployeeFavoriteJobAdvertisementDto;

public interface EmployeeFavoriteJobAdvertisementService {
    Result add(EmployeeFavoriteJobAdvertisementDto favoriteDto);
}
