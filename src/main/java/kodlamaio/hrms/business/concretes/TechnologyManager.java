package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.TechnologyDao;
import kodlamaio.hrms.entities.concretes.Technology;
import kodlamaio.hrms.entities.dtos.TechnologyEditDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {

    private final TechnologyDao technologyDao;

    @Autowired
    public TechnologyManager(TechnologyDao technologyDao) {
        this.technologyDao = technologyDao;
    }

    @Override
    public DataResult<List<TechnologyEditDto>> getByResume_Id(int resumeId) {
        List<TechnologyEditDto> technologyEditDtoList = new ArrayList<>();
        for(Technology technology : this.technologyDao.getByResume_Id(resumeId)) {
            TechnologyEditDto technologyEditDto = new TechnologyEditDto();
            technologyEditDto.setId(technology.getId());
            technologyEditDto.setName(technology.getName());
            technologyEditDtoList.add(technologyEditDto);
        }
        return new SuccessDataResult<>(technologyEditDtoList, "Technologies of resume listed");
    }
}
