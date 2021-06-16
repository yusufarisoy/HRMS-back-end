package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.abstracts.FileUploadService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.*;
import kodlamaio.hrms.entities.concretes.*;
import kodlamaio.hrms.entities.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class ResumeManager implements ResumeService {

    private final ResumeDao resumeDao;
    private final EmployeeDao employeeDao;
    private final EducationDao educationDao;
    private final ExperienceDao experienceDao;
    private final LanguageDao languageDao;
    private final TechnologyDao technologyDao;
    private final FileUploadService fileUploadService;

    @Autowired
    public ResumeManager(ResumeDao resumeDao, EmployeeDao employeeDao, EducationDao educationDao, ExperienceDao experienceDao, LanguageDao languageDao,
                         TechnologyDao technologyDao, FileUploadService fileUploadService) {
        super();
        this.resumeDao = resumeDao;
        this.employeeDao = employeeDao;
        this.educationDao = educationDao;
        this.experienceDao = experienceDao;
        this.languageDao = languageDao;
        this.technologyDao = technologyDao;
        this.fileUploadService = fileUploadService;
    }

    @Override
    public Result add(ResumeDto resumeDto) {
        if(this.employeeDao.findById(resumeDto.getEmployeeId()).isPresent()) {
            Resume resume = new Resume();
            Employee employee = this.employeeDao.findById(resumeDto.getEmployeeId()).get();
            resume.setEmployee(employee);

            resume.setCreateDate(new Date());
            if(resumeDto.getPhotoUrl() != null) {
                resume.setPhotoUrl(resumeDto.getPhotoUrl());
            } if(resumeDto.getGithubUrl() != null) {
                resume.setGithubUrl(resumeDto.getGithubUrl());
            } if(resumeDto.getLinkedInUrl() != null) {
                resume.setLinkedInUrl(resumeDto.getLinkedInUrl());
            }
            resume.setDescription(resumeDto.getDescription());

            this.resumeDao.save(resume);

            for(EducationDto educationDto : resumeDto.getEducationDtoList()) {
                Education education = new Education();
                education.setResume(resume);
                education.setName(educationDto.getName());
                education.setDepartment(educationDto.getDepartment());
                education.setStartDate(educationDto.getStartDate());
                education.setFinishDate(educationDto.getFinishDate());
                this.educationDao.save(education);
            }

            for(ExperienceDto experienceDto : resumeDto.getExperienceDtoList()) {
                Experience experience = new Experience();
                experience.setResume(resume);
                experience.setName(experienceDto.getName());
                experience.setDepartment(experienceDto.getDepartment());
                experience.setStartDate(experienceDto.getStartDate());
                experience.setFinishDate(experienceDto.getFinishDate());
                this.experienceDao.save(experience);
            }

            for(LanguageDto languageDto : resumeDto.getLanguageDtoList()) {
                Language language = new Language();
                language.setResume(resume);
                language.setName(languageDto.getName());
                language.setLevel(languageDto.getLevel());
                this.languageDao.save(language);
            }

            for(TechnologyDto technologyDto : resumeDto.getTechnologyDtoList()) {
                Technology technology = new Technology();
                technology.setResume(resume);
                technology.setName(technologyDto.getName());
                this.technologyDao.save(technology);
            }

            return new SuccessResult("Resume added");
        }
        return new ErrorResult("Employee doesn't exist");
    }

    @Override
    public Result upload(int resumeId, MultipartFile multipartFile) {
        if(this.resumeDao.findById(resumeId).isPresent()) {
            Resume res = this.resumeDao.findById(resumeId).get();
            res.setPhotoUrl(multipartFile.getName());

            return this.fileUploadService.upload(multipartFile);
        }

        return new ErrorResult("Incorrect Resume Id");
    }

    @Override
    public DataResult<List<Resume>> getAllSortedByGraduationDate() {
        Sort sort = Sort.by(Sort.Direction.DESC, "educations.finishDate");
        return new SuccessDataResult<>(this.resumeDao.findAll(sort), "All Resumes sorted and listed");
    }

    @Override
    public DataResult<List<Resume>> getAllSortedByExperienceYear() {
        Sort sort = Sort.by(Sort.Direction.DESC, "experiences.finishDate");
        return new SuccessDataResult<>(this.resumeDao.findAll(sort), "All Resumes sorted and listed");
    }

    @Override
    public DataResult<List<Resume>> getByEmployee_Id(int employerId) {
        return new SuccessDataResult<>(this.resumeDao.getByEmployee_Id(employerId), "All Resumes of Employee listed");
    }
}
