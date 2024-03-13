import CONTROLLER.SesionController;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        SesionController sesionController = new SesionController();
        sesionController.start();
    }
}
