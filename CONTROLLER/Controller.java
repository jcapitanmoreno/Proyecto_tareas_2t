package CONTROLLER;

import INTERFACES.Icontroller;
import Serializator.Serializator;
import VIEW.CreateProyectView;
import VIEW.DeleteProyectView;
import VIEW.DeleteUserView;
import VIEW.MainView;

import java.io.Serializable;

public class Controller implements Icontroller, Serializable {
    CreateProyectView createProyectView = new CreateProyectView();
    MainView mainView = new MainView();
    DeleteProyectView deleteProyectView = new DeleteProyectView();
    DeleteUserView deleteUserView = new DeleteUserView();

    @Override
    public void start() {
        int option = -1;
        do{
            option = mainView.chooseOption();
            manejarOpcionMenu(option);
        }while(option!=7);
    }

    // Método para manejar la lógica del menú
    public void manejarOpcionMenu(int opcion) {
        switch (opcion) {
            case 1:
                mainView.listProyectMsg();
                break;
            case 2:
                mainView.listUserMsg();
                break;
            case 3:
                deleteUserView.deleteUserMsg();
                break;
            case 4:
                createProyectView.createProyect();
                break;
            case 5:
                deleteProyectView.deleteProyectMsg();
                break;
            case 6:
                mainView.accessToProyectMsg();
                break;
            case 7:
                mainView.logOutMsg();
                break;
            default:
                System.out.println("Opción no válida, por favor intente de nuevo.");
                break;
        }
    }
}