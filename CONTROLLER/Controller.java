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
    TaskFunctions taskFunctions = new TaskFunctions();
    AccessToProjectView accessToProjectView = new AccessToProjectView();
    ListProyectController listProyectController = new ListProyectController();
    ListUserController listUserController = new ListUserController();


    /**
     * Inicia el programa ejecutando un bucle que solicita al usuario que elija una opción del menú principal.
     * El bucle se ejecuta hasta que el usuario selecciona la opción de salida (7).
     * En cada iteración, se obtiene la opción seleccionada por el usuario y se maneja llamando al método manejarOpcionMenu().
     * @throws NoSuchAlgorithmException si ocurre un error relacionado con el algoritmo de hash (en caso de que se use).
     */
    @Override
    public void start() throws NoSuchAlgorithmException {
        int option = -1;
        do {
            option = mainView.chooseOption();
            manejarOpcionMenu(option);
        } while (option != 7);
    }
    /**
     * Maneja la opción seleccionada por el usuario en el menú principal.
     * Ejecuta la acción correspondiente según la opción seleccionada.
     * @param opcion La opción seleccionada por el usuario.
     * @throws NoSuchAlgorithmException si ocurre un error relacionado con el algoritmo de hash (en caso de que se use).
     */
    public void manejarOpcionMenu(int opcion) throws NoSuchAlgorithmException {
        switch (opcion) {
            case 1:
                mainView.listProyectMsg();
                listProyectController.listProjects();
                break;
            case 2:
                mainView.listUserMsg();
                listUserController.listUser();
                break;
            case 3:
                deleteUserView.deleteUserMsg();
                if (repoUsers.delete(deleteUserView.userToDelete())) {
                    repoUsers.save();
                }else {
                    deleteUserView.errordeleteUserMsg();
                }
                break;
            case 4:
                chooseToCreate();
                break;
            case 5:
                deleteProyectView.deleteProyectMsg(repoProject.delete(deleteProyectView.proyectToDelete()));
                repoProject.save();
                break;
            case 6:
                Project project = accessToProjectView.soliciteNameProject();
                if (repoProject.access(project)){
                    repoProject.setProjectToAccess(project);
                    mainView.accessToProyectMsg();
                    taskFunctions.manejarOpcionMenuTarea(project);
                }else{
                    accessToProjectView.errorToAcces();
                }
                break;
            case 7:
                welcomeByeView.byeProgram();
                System. exit(0);
                break;
            default:
                createProyectView.printMsg3();
                break;
        }
    }

    /**
     * Maneja la creación de un nuevo proyecto.
     * Muestra un menú para que el usuario elija entre crear un nuevo proyecto o volver al menú principal.
     * Si elige crear un nuevo proyecto, llama al método switchToCreate().
     * @throws NoSuchAlgorithmException si ocurre un error relacionado con el algoritmo de hash (en caso de que se use).
     */

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
    /**
     * Maneja las opciones relacionadas con la creación de un proyecto.
     * Si el usuario elige crear un nuevo proyecto (opción 1), solicita los detalles del proyecto,
     * comprueba si el proyecto ya existe en el repositorio y, si no existe, lo añade al repositorio y lo guarda.
     * Si el usuario elige volver al menú principal (opción 2), llama al método start() para reiniciar el ciclo.
     * @param opcionMenuToCreate La opción seleccionada por el usuario relacionada con la creación de proyectos.
     * @throws NoSuchAlgorithmException si ocurre un error relacionado con el algoritmo de hash (en caso de que se use).
     */
    public void switchToCreate(int opcionMenuToCreate) throws NoSuchAlgorithmException {
        switch (opcionMenuToCreate) {
            case 1:
                Project project = createProyectView.createProyect();
                if (repoProject.isProjectExist(project)){
                    createProyectView.printMsg1();
                }else {
                    repoProject.add(project);
                    repoProject.save();
                    createProyectView.printMsg2();
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