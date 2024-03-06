package Test;

import CONTROLLER.Controller;
import VIEW.SesionView;

public class SesionViewTest {
    public static void main(String[] args) {
        Controller controller = new Controller();
        SesionView mainView = new SesionView(controller);
        mainView.sesionView();
    }
}
