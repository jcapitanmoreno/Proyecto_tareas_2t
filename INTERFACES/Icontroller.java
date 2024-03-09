package INTERFACES;

import java.security.NoSuchAlgorithmException;

public interface Icontroller {
    int start() throws NoSuchAlgorithmException;
    void manejarOpcionMenu(int opcion) throws NoSuchAlgorithmException;
}