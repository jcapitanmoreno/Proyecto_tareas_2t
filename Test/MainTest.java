package Test;

import CONTROLLER.SesionController;

import java.security.NoSuchAlgorithmException;

public class MainTest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        SesionController sesionController = new SesionController();
        sesionController.startApp();
    }
}
