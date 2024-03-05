package Test;

import CONTROLLER.LogInController;
import VIEW.LogInView;

public class LoginTest {
    public static void main(String[] args) {
        LogInView logInView = new LogInView();
        LogInController logInController = new LogInController(logInView);
        logInController.startLogInProcess();
    }
}
