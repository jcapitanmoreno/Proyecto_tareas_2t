package INTERFACES;

import MODEL.User;

import java.security.NoSuchAlgorithmException;

public interface ILogInView {
    int chooseLogIn();
    String enterUsername();
    String enterPassword();
    void usernamePasswordError();
    void IniciarSesion() throws NoSuchAlgorithmException;
    void Error();

    User solicitateUser() throws NoSuchAlgorithmException;
}