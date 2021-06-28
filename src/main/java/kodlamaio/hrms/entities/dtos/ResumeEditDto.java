package kodlamaio.hrms.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeEditDto {
    private int id;
    private String photoUrl;
    private String githubUrl;
    private String linkedInUrl;
    private String description;
    //Dto
    private EducationEditDto[] educationEditDtoList;
    private ExperienceEditDto[] experienceEditDtoList;
    private LanguageEditDto[] languageEditDtoList;
    private TechnologyEditDto[] technologyEditDtoList;
    //Delete - they store the ids of the deleted ones
    private int[] educationDeleteList;
    private int[] experienceDeleteList;
    private int[] languageDeleteList;
    private int[] technologyDeleteList;
}
