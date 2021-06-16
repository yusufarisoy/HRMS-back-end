package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LanguageDao extends JpaRepository<Language, Integer> {
    List<Language> getByResume_Id(int resumeId);
}
