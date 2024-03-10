package INTERFACES;

import java.security.NoSuchAlgorithmException;

public interface Icontroller {
    void start() throws NoSuchAlgorithmException;
    void manejarOpcionMenu(int opcion) throws NoSuchAlgorithmException;
}