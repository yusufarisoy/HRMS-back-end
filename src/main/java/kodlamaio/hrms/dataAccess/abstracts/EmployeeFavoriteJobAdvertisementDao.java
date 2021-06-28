package kodlamaio.hrms.dataAccess.abstracts;

import kodlamaio.hrms.entities.concretes.EmployeeFavoriteJobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeFavoriteJobAdvertisementDao extends JpaRepository<EmployeeFavoriteJobAdvertisement, Integer> {
    EmployeeFavoriteJobAdvertisement getByEmployee_IdOrJobAdvertisement_Id(int employeeId, int jobAdvertisementId);
}
