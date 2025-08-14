package model;

import java.time.LocalDate;

public class AssignedSchedule {
    private final String empId;
    private final String scheduleId;
    private LocalDate assignmentDate;

    public AssignedSchedule(String empId, String scheduleId, LocalDate assignmentDate) {
        this.empId = empId;
        this.scheduleId = scheduleId;
        this.assignmentDate = assignmentDate;
    }
}
