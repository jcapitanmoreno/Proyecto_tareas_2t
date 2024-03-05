package MODEL;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Project implements Serializable {

    protected String name;
    protected String description;

    protected User ProjectCreator;
    protected List<User> collaborators;
    protected List<Task> tasks;

    public Project(String name, String description, User projectCreator, List<User> collaborators, List<Task> tasks) {
        this.name = name;
        this.description = description;
        ProjectCreator = projectCreator;
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
        return ProjectCreator;
    }

    public void setProjectCreator(User projectCreator) {
        ProjectCreator = projectCreator;
    }

    /**@Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ProjectCreator='" + ProjectCreator + '\'' +
                '}';
    }**/

    @Override
    public String toString() {
        return "╔═════════════════════════════════════╗\n" +
                String.format("║ %-5s: %-28s ║\n", "Name", name) +
                String.format("║ %-10s: %-13s ║\n", "Creador del Proyecto", ProjectCreator) +
                "╚═════════════════════════════════════╝\n" +
                "Descripción:" + description;
    }


}
