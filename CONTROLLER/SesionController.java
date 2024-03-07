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
    public void chooseoption() throws NoSuchAlgorithmException {
        int opcion = -1;
        do {
            opcion = sesionView.chooseoption();
            manejarOpcionMenu(opcion);
        } while (opcion != 3);
    }


    // Método para manejar la opción seleccionada del menú
    public void manejarOpcionMenu(int opcion) throws NoSuchAlgorithmException {
        switch (opcion) {
            case 1:
                chooseToLogIn();
                break;
            case 2:
                createUserView.createInformation();
                break;
            case 3:
                welcomeByeView.byeProgram();
                break;
            default:

        }
    }


    public void chooseToLogIn() throws NoSuchAlgorithmException {
        int opcionMenu = -1;
        do {
            opcionMenu = login.chooseLogIn();
            switchToLogIn(opcionMenu);
        } while (opcionMenu != 2);
    }

    public void switchToLogIn(int opcionMenu) throws NoSuchAlgorithmException {
        switch (opcionMenu){
            case 1:
                login.IniciarSesion();
                break;
            case 2:
                sesionView.chooseoption();
                break;
            default:
                sesionView.errorOption();
        }
    }
}