package entities.response;

import entities.Status;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class TaskResponse {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private Status status;
    private LocalDate dtStart;
    private LocalDate dtEnd;

    public TaskResponse(String name, String description, Status status, LocalDate dtStart, LocalDate dtEnd) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.dtStart = dtStart;
        this.dtEnd = dtEnd;
    }
}
