package org.example;
import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/timesheets")
public class TimesheetController {
    @Autowired
    public TimesheetService timesheetService;

    @Autowired
    public ProjectService projectService;

    @PostMapping
    public ResponseEntity<Timesheet> createTimesheet(@RequestBody Timesheet timesheet) {
        // Проверяем, что проект с указанным id существует
        Optional<Project> project = projectService.findById(timesheet.getProjectId());
        if (project.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        // Устанавливаем текущее время на сервере
        timesheet.setCreatedAt(LocalDateTime.now());

        Timesheet createdTimesheet = timesheetService.save(timesheet);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTimesheet);
    }

}
