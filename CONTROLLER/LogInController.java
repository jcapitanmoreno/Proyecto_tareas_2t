package CONTROLLER;

import INTERFACES.ILoginController;
import IO.Security;
import VIEW.LogInView;
import VIEW.MainView;

import java.security.NoSuchAlgorithmException;

public class LogInController implements ILoginController {
    MainView mainView = new MainView();
    LogInView logInView = new LogInView();

    public LogInController(LogInView logInView) {
        this.logInView = logInView;
    }
}