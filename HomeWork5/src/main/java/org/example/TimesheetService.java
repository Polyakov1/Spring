package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimesheetService {
    @Autowired
    private TimesheetRepository timesheetRepository;

    public List<Timesheet> getTimesheetsByEmployeeId(Long employeeId) {
        return timesheetRepository.findByEmployeeId(employeeId);
    }
}