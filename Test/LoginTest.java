package Test;

import CONTROLLER.LogInController;
import VIEW.LogInView;

import java.security.NoSuchAlgorithmException;

public class LoginTest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        LogInView logInView = new LogInView();
        LogInController logInController = new LogInController(logInView);
        //logInController.;

    }
}
