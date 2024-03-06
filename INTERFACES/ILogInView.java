package INTERFACES;

import java.security.NoSuchAlgorithmException;

public interface ILogInView {
    String chooseLogIn();
    String enterUsername();
    String enterPassword();
    void usernamePasswordError();
    void IniciarSesion() throws NoSuchAlgorithmException;
    void Error();
}
