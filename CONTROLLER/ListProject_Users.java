package CONTROLLER;

import MODEL.Project;
import MODEL.RepoProject;
import MODEL.RepoUsers;
import MODEL.User;

public class ListProject_Users {
    RepoProject repoProject = new RepoProject();
    //RepoUsers repoUsers = new RepoUsers();

    public void listProjects(){
        //List<Project> projects = (List<Project>) repoProject.getAll();
        for (Project project : repoProject.getAll()) {
            System.out.println(project);
        }
    }
    /**public void listUsers(){
        for (User user : repoUsers.getAll()) {
            System.out.println(user);
        }
    }**/
}
