package MODEL;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public class Task implements Serializable {

    private String name;
    private String description;
    private LocalDate starterDate;
    private LocalDate limitDate;
    private String projectColaborator;
    private TaskStatus taskStatus;

    public Task() {
        projectColaborator = "";
    }

    public Task(String name, String description, LocalDate starterDate, LocalDate limitDate, String projectColaborator, TaskStatus taskStatus) {
        this.name = name;
        this.description = description;
        this.starterDate = starterDate;
        this.limitDate = limitDate;
        this.projectColaborator = projectColaborator;
        this.taskStatus = TaskStatus.SIN_INICIAR;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStarterDate() {
        return starterDate;
    }

    public void setStarterDate(LocalDate starterDate) {
        this.starterDate = starterDate;
    }

    public LocalDate getLimitDate() {
        return limitDate;
    }

    public void setLimitDate(LocalDate limitDate) {
        this.limitDate = limitDate;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getProjectColaborator() {
        return projectColaborator;
    }

    public void setProjectColaborator(String projectColaborator) {
        this.projectColaborator = projectColaborator;
    }

    @Override
    public String toString() {
        return "╔═════════════════════════════════════╗\n" +
                String.format("║ %-5s: %-28s \n", "Name", name) +
                String.format("║ %-10s: %-13s \n", "F. inicio de la tarea", starterDate) +
                String.format("║ %-10s: %-13s \n", "F. límite de la tarea", limitDate) +
                String.format("║ %-10s: %-13s \n", "Encargado de la tarea", projectColaborator) +
                String.format("║ %-10s: %-13s \n", "Estado de la tarea", taskStatus) +
                "╚═════════════════════════════════════╝\n" +
                "Descripción:" + description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return Objects.equals(name, task.name);
    }
}
