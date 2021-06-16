package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.TechnologyDao;
import kodlamaio.hrms.entities.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {

    private final TechnologyDao technologyDao;

    @Autowired
    public TechnologyManager(TechnologyDao technologyDao) {
        this.technologyDao = technologyDao;
    }

    @Override
    public DataResult<List<Technology>> getByResume_Id(int resumeId) {
        return new SuccessDataResult<>(this.technologyDao.getByResume_Id(resumeId), "");
    }
}
