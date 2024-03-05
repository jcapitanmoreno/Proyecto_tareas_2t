package CONTROLLER;

import MODEL.Project;
import MODEL.User;
import Serializator.Serializator;
import VIEW.CreateProyectView;

import java.util.Iterator;
import java.util.List;

public class CreateProject {
    private List<Project> projects;
    CreateProyectView createProyectView = new CreateProyectView();

    public boolean createUser(Project p) {
        boolean userAdded = false;
        createProyectView.createProyect();
        if (!projects.contains(p)) {
            projects.add(p);
            userAdded = true;
        }
        return userAdded;

    }

    public Project removeUser(Project p){
        Project projectToRemove = null;
        Iterator<Project> iterator = projects.iterator();
        while (iterator.hasNext()){
            Project temporalProject = iterator.next();
            if (temporalProject.equals(p)){
                projectToRemove = temporalProject;
                iterator.remove();
            }
        }
        return projectToRemove;
    }
}
