package org.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@Getter
@Setter
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TimesheetService timesheetService;

    @GetMapping("/{id}/timesheets")
    public List<Timesheet> getTimesheetsByEmployeeId(@PathVariable Long id) {
        return timesheetService.getTimesheetsByEmployeeId(id);
    }
}