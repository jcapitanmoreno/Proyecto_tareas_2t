package MODEL;

import INTERFACES.Iproject;
import java.util.ArrayList;
import java.util.List;

public class Project implements Iproject {
    protected String name;
    protected String description;
    protected String projectCreator;
    protected List<Users> collaborators;

    public Project(String name, String description, String projectCreator) {
        this.name = name;
        this.description = description;
        this.projectCreator = projectCreator;
        this.collaborators = new ArrayList<>();
    }

    // Getters y setters
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

    public String getProjectCreator() {
        return projectCreator;
    }

    public void setProjectCreator(String projectCreator) {
        this.projectCreator = projectCreator;
    }


    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", projectCreator='" + projectCreator + '\'' +
                ", collaborators=" + collaborators +
                '}';
    }
}