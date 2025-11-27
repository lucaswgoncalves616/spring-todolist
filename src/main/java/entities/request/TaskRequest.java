package entities.request;

import entities.Status;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class TaskRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private Status status;
    private LocalDate dtStart;
    private LocalDate dtEnd;

    public TaskRequest(String name, String description, Status status, LocalDate dtStart, LocalDate dtEnd) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.dtStart = dtStart;
        this.dtEnd = dtEnd;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getDtStart() {
        return dtStart;
    }

    public LocalDate getDtEnd() {
        return dtEnd;
    }
}
