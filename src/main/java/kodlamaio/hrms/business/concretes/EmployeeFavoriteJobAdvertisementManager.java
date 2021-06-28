package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployeeFavoriteJobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployeeFavoriteJobAdvertisementDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.EmployeeFavoriteJobAdvertisement;
import kodlamaio.hrms.entities.dtos.EmployeeFavoriteJobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeFavoriteJobAdvertisementManager implements EmployeeFavoriteJobAdvertisementService {

    private final EmployeeFavoriteJobAdvertisementDao favoritesDao;
    private final EmployeeDao employeeDao;
    private final JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public EmployeeFavoriteJobAdvertisementManager(EmployeeFavoriteJobAdvertisementDao favoritesDao, EmployeeDao employeeDao, JobAdvertisementDao jobAdvertisementDao) {
        this.favoritesDao = favoritesDao;
        this.employeeDao = employeeDao;
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public Result add(EmployeeFavoriteJobAdvertisementDto favoriteDto) {
        if(this.employeeDao.findById(favoriteDto.getEmployeeId()).isPresent() && this.jobAdvertisementDao.findById(favoriteDto.getJobAdvertisementId()).isPresent()
                && this.favoritesDao.getByEmployee_IdOrJobAdvertisement_Id(favoriteDto.getEmployeeId(), favoriteDto.getJobAdvertisementId()) == null) {
            EmployeeFavoriteJobAdvertisement favorite = new EmployeeFavoriteJobAdvertisement();
            favorite.setEmployee(this.employeeDao.findById(favoriteDto.getEmployeeId()).get());
            favorite.setJobAdvertisement(this.jobAdvertisementDao.findById(favoriteDto.getJobAdvertisementId()).get());

            this.favoritesDao.save(favorite);
            return new SuccessResult("Ad successfully added to favorites");
        }

        return new ErrorResult("Invalid request");
    }
}
