package kodlamaio.hrms.core.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.core.abstracts.FileUploadService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public class CloudinaryAdapter implements FileUploadService {

    public Result upload(MultipartFile multipartFile) {
        try {
            Cloudinary cloudinary = new Cloudinary();
            cloudinary.uploader().upload(multipartFile, ObjectUtils.emptyMap());

            return new SuccessResult("Image Uploaded Successfully");
        } catch (IOException ex) {
            return new ErrorResult("Upload Error!");
        }
    }
}
