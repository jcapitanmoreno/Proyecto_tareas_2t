package CONTROLLER;



import INTERFACES.ILoginController;
import IO.Security;
import VIEW.LogInView;
import VIEW.MainView;

import java.security.NoSuchAlgorithmException;

public class LogInController implements ILoginController {
    MainView mainView=new MainView();
    private LogInView logInView;

    public LogInController(LogInView logInView) {
        this.logInView = logInView;
    }

    public void startLogInProcess() throws NoSuchAlgorithmException {
        String option = logInView.chooseLogIn();
        switch (option.toLowerCase()) {
            case "iniciar":
                String username = logInView.enterUsername();
                String password = Security.hashPassword(logInView.enterPassword());
                System.out.println((password));

                System.out.println("Inicio de sesión con usuario: " + username + " y contraseña: " + password);
                break;
            case "volver":
                    mainView.chooseOption();
                break;
            default:
                System.out.println("Opción no válida, por favor intente de nuevo.");
                break;
        }
    }
}