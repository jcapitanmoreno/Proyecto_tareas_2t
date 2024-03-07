package Test;

import CONTROLLER.SesionController;
import VIEW.SesionView;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;

public class SesionViewTest  {
    SesionView sesionView= new SesionView();
    public static void main(String[] args) throws NoSuchAlgorithmException {
        SesionController sesionController = new SesionController();
        sesionController.chooseoption();
    }
}
