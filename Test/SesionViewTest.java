package Test;

import CONTROLLER.SesionController;
import VIEW.SesionView;

public class SesionViewTest {
    SesionView sesionView= new SesionView();
    public static void main(String[] args) {
        SesionController sesionController = new SesionController();
        sesionController.chooseoption();
    }
}
