package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.abstracts.FileUploadService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Service
public class ResumeManager implements ResumeService {

    private final ResumeDao resumeDao;
    private final FileUploadService fileUploadService;

    @Autowired
    public ResumeManager(ResumeDao resumeDao, FileUploadService fileUploadService) {
        super();
        this.resumeDao = resumeDao;
        this.fileUploadService = fileUploadService;
    }

    @Override
    public Result add(Resume resume) {
        this.resumeDao.save(resume);
        return new SuccessResult("Resume added");
    }

    @Override
    public Result upload(int resumeId, MultipartFile multipartFile) {
        if(this.resumeDao.findById(resumeId).isPresent()) {
            Resume res = this.resumeDao.findById(resumeId).get();
            res.setPhotoUrl(multipartFile.getName());

            //return new ErrorResult("Incorrect Resume Id");
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
