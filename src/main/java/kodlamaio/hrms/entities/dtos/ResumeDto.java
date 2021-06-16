package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeDto {
    private int employeeId;
    private String photoUrl;
    private String githubUrl;
    private String linkedInUrl;
    private String description;
    //Dto
    private EducationDto[] educationDtoList;
    private ExperienceDto[] experienceDtoList;
    private LanguageDto[] languageDtoList;
    private TechnologyDto[] technologyDtoList;
}
