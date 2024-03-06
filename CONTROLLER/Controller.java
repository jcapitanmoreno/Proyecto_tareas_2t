package CONTROLLER;

import INTERFACES.Icontroller;
import VIEW.DeleteProyectView;
import VIEW.DeleteUserView;
import VIEW.MainView;
import com.sun.tools.javac.Main;


public class Controller implements Icontroller {
    MainView mainView = new MainView();
    DeleteUserView deleteUserView = new DeleteUserView();
    DeleteProyectView deleteProyectView = new DeleteProyectView();

    public void start(){
        int opcion=-1;
        do{
            opcion= mainView.chooseOption();
            manejarOpcionMenu(opcion);
        }while(opcion!=7);
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
                mainView.createProyectMsg();
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
