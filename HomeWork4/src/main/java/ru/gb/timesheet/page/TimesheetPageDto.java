package ru.gb.timesheet.page;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.gb.timesheet.model.Project;
import ru.gb.timesheet.model.Timesheet;
import ru.gb.timesheet.service.ProjectService;

import java.util.List;

/**
 * Класс (DTO Data Transfer Object), который описывает параметры для шаблоново HTML-страниц.
 * Т.е. он нужен для передачи параметров внутрь thymeleaf в тех контроллерах, которые сразу отдают HTML-страницы.
 */
@Data
@Getter
@Setter
public class TimesheetPageDto {

  private String projectName;
  private String id;
  private String minutes;
  private String createdAt;
  ProjectService ProjectService;

  @GetMapping("/projects/{id}")
  public String getProject(@PathVariable Long id, Model model) {
    List<Timesheet> project = ProjectService.getTimesheets(id);
    model.addAttribute("project", project);
    return "project-page";
  }
}
