package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.SystemStaffService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerInformationUpdateDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.dataAccess.abstracts.SystemStaffDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.EmployerInformationUpdate;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.concretes.SystemStaff;
import kodlamaio.hrms.entities.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SystemStaffManager implements SystemStaffService {

    private final SystemStaffDao systemStaffDao;
    private final EmployerDao employerDao;
    private final JobAdvertisementDao jobAdvertisementDao;
    private final EmployerInformationUpdateDao employerInformationUpdateDao;

    @Autowired
    public SystemStaffManager(SystemStaffDao systemStaffDao, EmployerDao employerDao, JobAdvertisementDao jobAdvertisementDao, EmployerInformationUpdateDao employerInformationUpdateDao) {
        super();
        this.systemStaffDao = systemStaffDao;
        this.employerDao = employerDao;
        this.jobAdvertisementDao = jobAdvertisementDao;
        this.employerInformationUpdateDao = employerInformationUpdateDao;
    }

    @Override
    public Result add(SystemStaffDto systemStaffDto) {
        List<SystemStaff> staffList = this.systemStaffDao.findAll();
        for(SystemStaff staff : staffList) {
            if(staff.getMail().equals(systemStaffDto.getMail())) {
                return new ErrorResult("Personnel with mail already exists!");
            }
        }

        SystemStaff systemStaff = new SystemStaff();
        systemStaff.setName(systemStaffDto.getName());
        systemStaff.setMail(systemStaffDto.getMail());
        systemStaff.setPassword(systemStaffDto.getPassword());
        systemStaff.setPhone(systemStaffDto.getPhone());

        this.systemStaffDao.save(systemStaff);
        return new SuccessResult("New Staff added successfully");
    }

    @Override
    public DataResult<SystemStaff> logInWithEmailAndPassword(SystemStaffLoginDto loginParams) {
        List<SystemStaff> allStaff = this.systemStaffDao.findAll();
        for(SystemStaff staff : allStaff) {
            if(staff.getMail().equals(loginParams.getEmail()) && staff.getPassword().equals(loginParams.getPassword())) {
                return new SuccessDataResult<>(staff, "Authenticated successfully");
            }
        }

        return new ErrorDataResult<>(null, "Incorrect email or password!");
    }

    @Override
    public Result confirmEmployerRegister(SystemStaffConfirmationEmployerDto confirmationParams) {
        if(this.systemStaffDao.existsById(confirmationParams.getStaffId()) && this.employerDao.findById(confirmationParams.getEmployerId()).isPresent()) {
            Employer employer = this.employerDao.findById(confirmationParams.getEmployerId()).get();
            employer.setConfirmationStatus(confirmationParams.getConfirmationCode());
            this.employerDao.save(employer);

            String message;
            if(confirmationParams.getConfirmationCode() == 1) {
                message = "Information of employer confirmed by system personnel with id: " + confirmationParams.getStaffId();
            } else {
                //Going to be -1
                message = "Information of employer rejected by system personnel with id: " + confirmationParams.getStaffId();
            }

            return new SuccessResult(message);
        }

        return new ErrorResult("Not a valid system staff or employer");
    }

    @Override
    public Result approveJobAdvertisement(SystemStaffConfirmationJobAdvertisementDto confirmationParams) {
        if(this.systemStaffDao.existsById(confirmationParams.getStaffId()) && this.jobAdvertisementDao.findById(confirmationParams.getJobAdvertisementId()).isPresent()) {
            JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.findById(confirmationParams.getJobAdvertisementId()).get();
            jobAdvertisement.setApprovalStatus(confirmationParams.getApprovalStatus());
            this.jobAdvertisementDao.save(jobAdvertisement);

            String message;
            if(confirmationParams.getApprovalStatus() == 1) {
                message = "Job Advertisement with id: " + confirmationParams.getJobAdvertisementId() +
                        " approved by system personnel with id: " + confirmationParams.getStaffId();
            } else {
                message = "Job Advertisement with id: " + confirmationParams.getJobAdvertisementId() +
                        " rejected by system personnel with id: " + confirmationParams.getStaffId();
            }

            return new SuccessResult(message);
        }

        return new ErrorResult("Not a valid system staff or job-advertisement");
    }

    @Override
    public Result confirmEmployerInformationUpdate(SystemStaffConfirmationEmployerInformationUpdateDto confirmationParams) {
        if(this.employerInformationUpdateDao.findById(confirmationParams.getInformationUpdateId()).isPresent() && this.systemStaffDao.findById(confirmationParams.getSystemStaffId()).isPresent()) {
            EmployerInformationUpdate informationUpdate = this.employerInformationUpdateDao.findById(confirmationParams.getInformationUpdateId()).get();
            if(confirmationParams.getConfirmationCode() == 1) {
                Employer employer = informationUpdate.getEmployer();
                employer.setName(informationUpdate.getName());
                employer.setMail(informationUpdate.getMail());
                if(informationUpdate.getPassword() != null) {
                    employer.setPassword(informationUpdate.getPassword());
                }
                employer.setPhone(informationUpdate.getPhone());
                this.employerDao.save(employer);
            }

            informationUpdate.setConfirmationStatus(confirmationParams.getConfirmationCode());//-1 or 1
            this.employerInformationUpdateDao.save(informationUpdate);
            return new SuccessResult("Information update of employer with id: " + informationUpdate.getEmployer().getId() + " approved by system staff with id: " + confirmationParams.getSystemStaffId());
        }

        return new ErrorResult("Invalid or unauthorized request");
    }

    @Override
    public Result updateInformation(SystemStaffInformationUpdateDto informationUpdateDto) {
        if(this.systemStaffDao.findById(informationUpdateDto.getId()).isPresent()) {
            SystemStaff systemStaff = this.systemStaffDao.findById(informationUpdateDto.getId()).get();
            systemStaff.setName(informationUpdateDto.getName());
            systemStaff.setMail(informationUpdateDto.getMail());
            if(informationUpdateDto.getPassword() != null) {
                systemStaff.setPhone(informationUpdateDto.getPhone());
            }
            systemStaff.setPhone(informationUpdateDto.getPhone());

            this.systemStaffDao.save(systemStaff);
            return new SuccessResult("Information updated successfully");
        }

        return new ErrorResult("Unauthorized request");
    }
}
