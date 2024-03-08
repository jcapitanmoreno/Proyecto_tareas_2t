package CONTROLLER;

import INTERFACES.ISesionController;
import IO.Teclado;
import VIEW.CreateUserView;
import VIEW.LogInView;
import VIEW.SesionView;
import VIEW.WelcomeByeView;

import java.security.NoSuchAlgorithmException;

public class SesionController implements ISesionController {
    SesionView sesionView = new SesionView();
    LogInView login = new LogInView();
    CreateUserView createUserView = new CreateUserView();
    WelcomeByeView welcomeByeView = new WelcomeByeView();

    @Override
    public void startApp() throws NoSuchAlgorithmException {
        welcomeByeView.welcomeProgram();
        Teclado.pressEnter();
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
                userToCreate();
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
            if(opcionMenu == 2) {
                continueLoop = false;
            } else {
                switchToLogIn(opcionMenu);
            }
        } while (continueLoop);
    }

    public void switchToLogIn(int opcionMenu) throws NoSuchAlgorithmException {
        switch (opcionMenu){
            case 1:
                login.IniciarSesion();
                break;
            default:
                sesionView.errorOption();
        }
    }

    public void userToCreate(){
        createUserView.createInformation();
        createUserView.createUser();
    }

    public void chooseToCreate() throws NoSuchAlgorithmException {
        int opcionMenuCreateUser = -1;
        boolean continueLoopMenuCreateUser = true;
        do {
            opcionMenuCreateUser = createUserView.createInformation();
            if(opcionMenuCreateUser == 2) {
                continueLoopMenuCreateUser = false;
            } else {
                switchToCreateUser(opcionMenuCreateUser);
            }
        } while (continueLoopMenuCreateUser);
    }

    public void switchToCreateUser(int opcionMenuCreateUser) throws NoSuchAlgorithmException {
        switch (opcionMenuCreateUser){
            case 1:
                createUserView.createUser();
                break;
            default:
                createUserView.errorOption();
        }
    }
}