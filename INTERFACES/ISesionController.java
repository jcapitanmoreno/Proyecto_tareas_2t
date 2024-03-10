package INTERFACES;

import java.security.NoSuchAlgorithmException;

public interface ISesionController {
    int chooseoption() throws NoSuchAlgorithmException;
    void manejarOpcionMenu(int opcion) throws NoSuchAlgorithmException;
}
