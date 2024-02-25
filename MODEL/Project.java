package MODEL;

import INTERFACES.Iproject;

public class Project implements Iproject {

    protected String name;
    protected String description;

    protected String ProjectCreator;


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
        return ProjectCreator;
    }

    public void setProjectCreator(String projectCreator) {
        ProjectCreator = projectCreator;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ProjectCreator='" + ProjectCreator + '\'' +
                '}';
    }

    public Project(String name, String description, String projectCreator) {
        this.name = name;
        this.description = description;
        ProjectCreator = projectCreator;


    }
}
