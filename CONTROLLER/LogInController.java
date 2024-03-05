package CONTROLLER;



import INTERFACES.ILoginController;
import VIEW.LogInView;

public class LogInController implements ILoginController {
    private LogInView logInView;

    public LogInController(LogInView logInView) {
        this.logInView = logInView;
    }

    public void startLogInProcess() {
        String option = logInView.chooseLogIn();
        switch (option.toLowerCase()) {
            case "iniciar":
                String username = logInView.enterUsername();
                String password = logInView.enterPassword();

                System.out.println("Inicio de sesión con usuario: " + username + " y contraseña: " + password);
                break;
            case "volver":

                break;
            default:
                System.out.println("Opción no válida, por favor intente de nuevo.");
                break;
        }
    }
}