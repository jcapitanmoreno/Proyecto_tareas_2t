package CONTROLLER;

import INTERFACES.Icontroller;

import IO.Teclado;
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
    Teclado teclado = new Teclado();
    ListProject_Users listProjectUsers = new ListProject_Users();


    @Override
    public void start() throws NoSuchAlgorithmException {
        int option = -1;
        do {
            option = mainView.chooseOption();
            manejarOpcionMenu(option);
        } while (option != 7);
    }

    // Método para manejar la lógica del menú
    public void manejarOpcionMenu(int opcion) throws NoSuchAlgorithmException {
        switch (opcion) {
            case 1:
                mainView.listProyectMsg();
                listProjectUsers.listProjects();
                break;
            case 2:
                mainView.listUserMsg();
                listProjectUsers.listUsers();
                break;
            case 3:
                repoUsers.delete(deleteUserView.userToDelete());
                deleteUserView.deleteUserMsg();
                break;
            case 4:
                chooseToCreate();
                break;
            case 5:
                deleteProyectView.deleteProyectMsg(repoProject.delete(deleteProyectView.proyectToDelete()));
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
                    teclado.printMsg("el proyecto existe en el repositorio");
                }else {
                    repoProject.add(project);
                    repoProject.save();
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