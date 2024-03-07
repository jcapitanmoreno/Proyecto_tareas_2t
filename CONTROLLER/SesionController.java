package CONTROLLER;

import INTERFACES.ISesionController;
import IO.Teclado;
import MODEL.RepoUsers;
import MODEL.Session;
import VIEW.*;

import java.security.NoSuchAlgorithmException;

public class SesionController implements ISesionController {

    SesionView sesionView = new SesionView();
    LogInView login = new LogInView();
    CreateUserView createUserView = new CreateUserView();
    WelcomeByeView welcomeByeView = new WelcomeByeView();
    MainView mainView = new MainView();
    CreateUser createUser = new CreateUser();
    RepoUsers repoUsers=RepoUsers.getInstance();


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
                createUserView.createUser();
                break;
            case 3:
                welcomeByeView.byeProgram();
                break;
            default:
                sesionView.errorOption();
        }
    }

    public void chooseToLogIn() throws NoSuchAlgorithmException {
        int opcionMenu = -1;
        boolean continueLoop = true;
        do {
            opcionMenu = login.chooseLogIn();
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
               // login.IniciarSesion();

                if (repoUsers.login(Teclado.readString(""),Teclado.readString(""))) {
                    repoUsers.setUser();
                    mainView.chooseOption();
                }
            case 2:
                createUser.createUser();
                break;
            default:
                sesionView.errorOption();
        }
    }
}