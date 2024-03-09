package CONTROLLER;

import INTERFACES.ISesionController;
import IO.Teclado;
import MODEL.RepoUsers;
import MODEL.Session;
import MODEL.User;
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
    LogInView logInView = new LogInView();

    /**
     * Este método permite al usuario elegir una opción y maneja la opción seleccionada hasta que se elija la opción de salida.
     * @return La opción elegida por el usuario
     * @throws NoSuchAlgorithmException si ocurre un error en el manejo de la opción
     */
    @Override
    public int chooseoption() throws NoSuchAlgorithmException {
        int opcion = -1;
        do {
            opcion = sesionView.chooseoption();

            manejarOpcionMenu(opcion);

        } while (opcion != 3);
        return opcion;
    }

    /**
     * Maneja la opción del menú seleccionada por el usuario.
     * @param opcion La opción del menú seleccionada
     * @throws NoSuchAlgorithmException si ocurre un error en el manejo de la opción
     */
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
    /**
     * Permite al usuario elegir iniciar sesión y maneja la opción seleccionada hasta que se elija la opción de salida.
     * @throws NoSuchAlgorithmException si ocurre un error durante el proceso de inicio de sesión
     */
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
    /**
     * Maneja la opción de inicio de sesión seleccionada por el usuario.
     * @param opcionMenu La opción de inicio de sesión seleccionada
     * @throws NoSuchAlgorithmException si ocurre el mismo error antes mencionado
     */
    public void switchToLogIn(int opcionMenu) throws NoSuchAlgorithmException {
        switch (opcionMenu) {
            case 1:
                User user = logInView.solicitateUser();
                if (repoUsers.login(user)) {
                    repoUsers.setUserLogin(user);
                    System.out.println("true");
                    mainView.chooseOption();
                }else {
                    logInView.Error();
                }
                break;
            case 2:
                createUser.createUser();
                break;
            default:
                sesionView.errorOption();
        }
    }
}
