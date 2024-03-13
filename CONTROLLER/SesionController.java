package CONTROLLER;

import INTERFACES.ISesionController;
import IO.Teclado;
import MODEL.RepoUsers;
import MODEL.User;
import VIEW.*;

import java.security.NoSuchAlgorithmException;

public class SesionController implements ISesionController {

    SesionView sesionView = new SesionView();
    LogInView login = new LogInView();
    WelcomeByeView welcomeByeView = new WelcomeByeView();
    CreateUser createUser = new CreateUser();
    RepoUsers repoUsers=RepoUsers.getInstance();
    LogInView logInView = new LogInView();
    Controller controller = new Controller();
    Teclado teclado = new Teclado();
    CreateUserView createUserView = new CreateUserView();


    public void start() throws NoSuchAlgorithmException {
        welcomeByeView.welcomeProgram();
        chooseoption();
    }

    @Override
    public int chooseoption() throws NoSuchAlgorithmException {
        int opcion = -1;

        do {
            opcion = sesionView.chooseoption();
            manejarOpcionMenu(opcion);
        } while (opcion != 3);
        return opcion;
    }

    // Método para manejar la opción seleccionada del menú
    public void manejarOpcionMenu(int opcion) throws NoSuchAlgorithmException {
        switch (opcion) {
            case 1:
                chooseToLogIn();
                break;
            case 2:
                chooseToCreate();
                break;
            case 3:
                welcomeByeView.byeProgram();
                break;
            default:
                sesionView.errorOption();
        }
    }

    public void chooseToLogIn() throws NoSuchAlgorithmException {
        boolean continueLoop = true;
        do {
           int opcionMenu = login.chooseLogIn();
            if (opcionMenu == 2) {
                continueLoop = false;
            } else {
                switchToLogIn(opcionMenu);
            }
        } while (continueLoop);
    }

    public void switchToLogIn(int opcionMenu) throws NoSuchAlgorithmException {
        switch (opcionMenu) {
            case 1:
                User user = logInView.solicitateUser();
                if (repoUsers.login(user)) {
                    repoUsers.setUserLogin(user);
                    teclado.printMsg("El usuario es valido");
                    controller.start();
                }else {

                }
                break;
            case 2:
                break;
            default:
                sesionView.errorOption();
        }
    }

    public void chooseToCreate() throws NoSuchAlgorithmException {
        boolean continueLoopCreate = true;
        do {
            int opcionMenuCreate = createUserView.wantToCreate();
            if (opcionMenuCreate == 2) {
                continueLoopCreate = false;
            } else {
                switchToCreate(opcionMenuCreate);
            }
        } while (continueLoopCreate);
    }

    public void switchToCreate(int opcionMenu) throws NoSuchAlgorithmException {
        switch (opcionMenu) {
            case 1:
                createUser.createUser();
                break;
            case 2:
                break;
            default:
                sesionView.errorOption();
        }
    }
}
