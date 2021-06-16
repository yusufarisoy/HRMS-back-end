package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.PositionService;
import kodlamaio.hrms.core.utilities.results.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.PositionDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.Position;
import kodlamaio.hrms.entities.dtos.PositionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PositionManager implements PositionService
{
    private final PositionDao positionDao;
    private final EmployerDao employerDao;

    @Autowired
    public PositionManager(PositionDao positionDao, EmployerDao employerDao) {
        super();
        this.positionDao = positionDao;
        this.employerDao = employerDao;
    }

    @Override
    public DataResult<List<Position>> getAll() {
        return new SuccessDataResult<>(this.positionDao.findAll(), "Position list returned successfully");
    }

    @Override
    public DataResult<List<Position>> getByEmployer_Id(int employerId) {
        return new SuccessDataResult<>(this.positionDao.getByEmployer_Id(employerId), "Positions of employer listed");
    }

    @Override
    public Result add(PositionDto positionDto) {
        if(this.employerDao.findById(positionDto.getEmployerId()).isPresent()) {
            List<Position> positions = this.positionDao.findAll();
            for(Position pos : positions) {
                if(pos.getName().equals(positionDto.getName())) {
                    return new ErrorResult("Position with same name already exists!");
                }
            }

            Position position = new Position();
            Employer employer = this.employerDao.findById(positionDto.getEmployerId()).get();
            position.setEmployer(employer);
            position.setName(positionDto.getName());
            this.positionDao.save(position);

            return new SuccessResult("Position added");
        }

        return new ErrorResult("Not an existing Employer");
    }
}
