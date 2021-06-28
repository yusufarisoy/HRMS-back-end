package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerInformationUpdateService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerInformationUpdateDao;
import kodlamaio.hrms.entities.concretes.EmployerInformationUpdate;
import kodlamaio.hrms.entities.dtos.EmployerInformationUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class EmployerInformationUpdateManager implements EmployerInformationUpdateService {

    private final EmployerDao employerDao;
    private final EmployerInformationUpdateDao employerInformationUpdateDao;

    @Autowired
    public EmployerInformationUpdateManager(EmployerDao employerDao, EmployerInformationUpdateDao employerInformationUpdateDao) {
        super();
        this.employerDao = employerDao;
        this.employerInformationUpdateDao = employerInformationUpdateDao;
    }

    @Override
    public DataResult<List<EmployerInformationUpdate>> getByEmployer_Id(int employerId) {
        return new SuccessDataResult<>(this.employerInformationUpdateDao.getByEmployer_Id(employerId), "Information Updates Returned Successfully");
    }

    @Override
    public DataResult<EmployerInformationUpdate> getWaitingUpdateByEmployer_Id(int employerId) {
        List<EmployerInformationUpdate> informationUpdates = this.employerInformationUpdateDao.getByEmployer_Id(employerId);
        for(EmployerInformationUpdate update : informationUpdates) {
            if(update.getConfirmationStatus() == 0) {
                //For show status to employer
                return new SuccessDataResult<>(update, "Employer has an update waiting to be approved");
            }
        }

        return new ErrorDataResult<>();
    }

    @Override
    public DataResult<List<EmployerInformationUpdate>> getAll() {
        //For system staff to see every old and new update
        return new SuccessDataResult<>(this.employerInformationUpdateDao.findAll(), "All information updates listed");
    }

    @Override
    public Result add(EmployerInformationUpdateDto employerInformationUpdateDto) {
        if(this.employerDao.findById(employerInformationUpdateDto.getEmployerId()).isPresent()) {
            EmployerInformationUpdate informationUpdate = new EmployerInformationUpdate();
            informationUpdate.setEmployer(this.employerDao.findById(employerInformationUpdateDto.getEmployerId()).get());

            informationUpdate.setName(employerInformationUpdateDto.getName());
            informationUpdate.setMail(employerInformationUpdateDto.getMail());
            informationUpdate.setPhone(employerInformationUpdateDto.getPhone());
            if(!employerInformationUpdateDto.getPassword().equals("")) {
                informationUpdate.setPassword(employerInformationUpdateDto.getPassword());
            }
            informationUpdate.setConfirmationStatus(0);
            informationUpdate.setUpdateDate(new Date());

            this.employerInformationUpdateDao.save(informationUpdate);
            return new SuccessResult("Information update is set and waiting for confirmation");
        }
        return new ErrorResult("Employer doesn't exist");
    }
}
