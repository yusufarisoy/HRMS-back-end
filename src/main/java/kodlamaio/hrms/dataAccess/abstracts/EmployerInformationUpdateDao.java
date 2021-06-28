package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.EmployerInformationUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployerInformationUpdateDao extends JpaRepository<EmployerInformationUpdate, Integer> {
    List<EmployerInformationUpdate> getByEmployer_Id(int employerId);
}
