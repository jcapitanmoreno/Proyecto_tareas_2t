package MODEL;

import java.time.LocalDate;

public class Task {

    protected String name;
    protected String description;
    protected LocalDate starterDate;
    protected LocalDate limitDate;
    protected String projectColaborator;

    protected TaskStatus taskStatus;

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

    public String getProjectColaborator() {
        return projectColaborator;
    }

    public void setProjectColaborator(String projectColaborator) {
        this.projectColaborator = projectColaborator;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", starterDate=" + starterDate +
                ", limitDate=" + limitDate +
                ", projectColaborator='" + projectColaborator + '\'' +
                ", taskStatus=" + taskStatus +
                '}';
    }

    public Task(String name, String description, LocalDate starterDate, LocalDate limitDate, String projectColaborator, TaskStatus taskStatus) {
        this.name = name;
        this.description = description;
        this.starterDate = starterDate;
        this.limitDate = limitDate;
        this.projectColaborator = projectColaborator;
        this.taskStatus = taskStatus;

    }
}
