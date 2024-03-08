package INTERFACES;

import java.security.NoSuchAlgorithmException;

public interface ISesionController {
    void startApp() throws NoSuchAlgorithmException;
    int chooseoption() throws NoSuchAlgorithmException;
    void chooseToLogIn() throws NoSuchAlgorithmException;
    void switchToLogIn(int opcionMenu) throws NoSuchAlgorithmException;
    //void crearUsuarios();
    //void cerrarPrograma();
}
