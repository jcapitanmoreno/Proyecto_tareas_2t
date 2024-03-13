package MODEL;

import VIEW.CreateTaskView;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Project implements Serializable {

    private String name;
    private String description;
    private User projectCreator;
    private List<User> collaborators;
    private List<Task> tasks;

    public Project() {
    }

    public Project(String name, String description, User projectCreator, List<User> collaborators, List<Task> tasks) {
        this.name = name;
        this.description = description;
        this.projectCreator = projectCreator;
        this.collaborators = collaborators;
        this.tasks = tasks;
    }


    public List<User> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<User> collaborators) {
        this.collaborators = collaborators;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
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

    public User getProjectCreator() {
        return projectCreator;
    }

    public void setProjectCreator(User projectCreator) {
        this.projectCreator = projectCreator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name);
    }

    @Override
    public String toString() {
        return "╔═════════════════════════════════════╗\n" +
                String.format("║ %-5s: %-28s ║\n", "Name", name) +
                String.format("║ %-10s: %-13s ║\n", "Creador del Proyecto", projectCreator.getUser()) +
                "╚═════════════════════════════════════╝\n" +
                "Descripción:" + description+ "\n\n";
    }

    public  Task addTask(Task t){
        Task result = null;
        if (!tasks.contains(t)){
            tasks.add(t);
        }
        result = t;
        return result;
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return tasks.stream().filter(task -> task.getTaskStatus().equals(status)).collect(Collectors.toList());
    }

}
