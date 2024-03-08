package CONTROLLER;

import INTERFACES.Icontroller;

import MODEL.Project;
import MODEL.RepoProject;
import MODEL.RepoUsers;
import MODEL.User;
import VIEW.*;

import java.awt.*;
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
                listProyectView.listProyects();
                break;
            case 2:
                mainView.listUserMsg();
                repoUsers.toString();
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
}