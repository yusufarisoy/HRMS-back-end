package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.LanguageDao;
import kodlamaio.hrms.entities.concretes.Language;
import kodlamaio.hrms.entities.dtos.LanguageEditDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private final LanguageDao languageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    @Override
    public DataResult<List<LanguageEditDto>> getByResume_Id(int resumeId) {
        List<LanguageEditDto> languageEditDtoList = new ArrayList<>();
        for(Language language : this.languageDao.getByResume_Id(resumeId)) {
            LanguageEditDto languageEditDto = new LanguageEditDto();
            languageEditDto.setId(language.getId());
            languageEditDto.setName(language.getName());
            languageEditDto.setLevel(language.getLevel());
            languageEditDtoList.add(languageEditDto);
        }

        return new SuccessDataResult<>(languageEditDtoList, "Languages of resume listed");
    }
}
