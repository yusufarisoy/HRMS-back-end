package kodlamaio.hrms.core.concretes;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import kodlamaio.hrms.core.abstracts.FileUploadService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Service
public class CloudinaryAdapter implements FileUploadService {

    @Override
    public Result upload(MultipartFile profilePicture) {
        try {
            Cloudinary cloudinary = new Cloudinary();
            cloudinary.uploader().upload(profilePicture, ObjectUtils.emptyMap());

            return new SuccessResult("Image Uploaded Successfully");
        } catch (IOException ex) {
            return new ErrorResult("Upload Error!");
        }
    }
}
