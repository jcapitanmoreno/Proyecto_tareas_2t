package CONTROLLER;

import INTERFACES.Icontroller;

import MODEL.Project;
import MODEL.RepoProject;
import MODEL.RepoUsers;
import MODEL.User;
import VIEW.*;

import java.awt.*;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class Controller implements Icontroller {
    CreateProyectView createProyectView = new CreateProyectView();
    MainView mainView = new MainView();
    DeleteProyectView deleteProyectView = new DeleteProyectView();
    DeleteUserView deleteUserView = new DeleteUserView();
    WelcomeByeView welcomeByeView = new WelcomeByeView();

    RepoProject repoProject = RepoProject.get_Instance();
    RepoUsers repoUsers = RepoUsers.getInstance();
    CreateUser createUser = new CreateUser();
    CreateProyectController createProyectController = new CreateProyectController();
    ListProyectView listProyectView = new ListProyectView();
    private static List<MODEL.User> User;
    private static List<MODEL.Task> Task;


    @Override
    public void start() {
        int option = -1;
        do {
            option = mainView.chooseOption();
            manejarOpcionMenu(option);
        } while (option != 7);
    }

    // Método para manejar la lógica del menú
    public void manejarOpcionMenu(int opcion) {
        switch (opcion) {
            case 1:
                mainView.listProyectMsg();
                List<Project> projects = (List<Project>) repoProject.getAll();
                for (Project project : projects) {
                    System.out.println(project);
                }
                break;
            case 2:
                mainView.listUserMsg();
                for (User user : repoUsers.getAll()) {
                    System.out.println(user);
                }
                break;
            case 3:
                deleteUserView.deleteUserMsg();
                //createUser.removeUser();

                break;
            case 4:
                createProyectController.addProject();
                break;
            case 5:
                deleteProyectView.deleteProyectMsg();
                //repoProject.removeproject();
                break;
            case 6:
                mainView.accessToProyectMsg();
                break;
            case 7:
                welcomeByeView.byeProgram();
                break;
            default:
                System.out.println("Opción no válida, por favor intente de nuevo.");
                break;
        }
    }
    public void chooseToCreate() throws NoSuchAlgorithmException {
        boolean continueLoopToCreate = true;
        do {
            int opcionMenuToCreate = createProyectView.chooseoption();
            if (opcionMenuToCreate == 2) {
                continueLoopToCreate = false;
            } else {
                switchToCreate(opcionMenuToCreate);
            }
        } while (continueLoopToCreate);
    }
    public void switchToCreate(int opcionMenuToCreate) throws NoSuchAlgorithmException {
        switch (opcionMenuToCreate) {
            case 1:
                Project project = createProyectView.createProyect();
                if (repoProject.isProjectExist(project)){
                    createProyectController.addProject();
                }else {

                }
                break;
            case 2:
                start();

                break;
            default:
                mainView.errorOption();
        }
    }
}