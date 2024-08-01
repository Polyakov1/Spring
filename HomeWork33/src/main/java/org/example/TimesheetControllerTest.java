package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TimesheetControllerTest {

    @Test
    void testCreateTimesheet() {
        // Создаем mock-объекты для сервисов
        TimesheetService timesheetService = Mockito.mock(TimesheetService.class);
        ProjectService projectService = Mockito.mock(ProjectService.class);

        // Создаем объект Timesheet
        Timesheet timesheet = new Timesheet();
        timesheet.setProjectId(1L);

        // Создаем mock-проект
        Project project = new Project();
        project.setId(1L);
        project.setName("Test Project");
        Optional<Project> projectOptional = Optional.of(project);

        // Настраиваем mock-объекты
        Mockito.when(projectService.findById(1L)).thenReturn(projectOptional);
        Mockito.when(timesheetService.save(Mockito.any(Timesheet.class))).thenReturn(timesheet);

        // Создаем объект контроллера
        TimesheetController controller = new TimesheetController();
        controller.timesheetService = timesheetService;
        controller.projectService = projectService;

        // Вызываем метод createTimesheet
        ResponseEntity<Timesheet> response = controller.createTimesheet(timesheet);

        // Проверяем результат
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(1L, response.getBody().getProjectId());
        // Проверяем, что время было установлено
        assertNotNull(response.getBody().getCreatedAt());
    }
}

