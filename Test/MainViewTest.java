package Test;

import CONTROLLER.Controller;
import VIEW.MainView;

public class MainViewTest {
    public static void main(String[] args) {
        Controller controller = new Controller();
        MainView mainView = new MainView(controller);
        mainView.mostrarMenu();
    }
}
