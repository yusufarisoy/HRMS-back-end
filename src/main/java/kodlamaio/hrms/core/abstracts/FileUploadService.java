package kodlamaio.hrms.core.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    Result upload(MultipartFile profilePicture);
}
