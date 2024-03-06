package Test;

import VIEW.CreateProyectView;
import VIEW.CreateUserView;
import VIEW.MainView;

public class CreateProyectTest {
    static CreateProyectView createProyectView = new CreateProyectView();
    static MainView mainView = new MainView();
    public static void main(String[] args) {
        mainView.createProyectMsg();
        createProyectView.createProyect();
    }
}
