package CONTROLLER;

import INTERFACES.Icontroller;

import MODEL.RepoProject;
import MODEL.RepoUsers;
import VIEW.*;

public class Controller implements Icontroller {
    CreateProyectView createProyectView = new CreateProyectView();
    MainView mainView = new MainView();
    DeleteProyectView deleteProyectView = new DeleteProyectView();
    DeleteUserView deleteUserView = new DeleteUserView();
    WelcomeByeView welcomeByeView= new WelcomeByeView();
  
    RepoProject repoProject =  RepoProject.get_Instance();
    RepoUsers repoUsers = RepoUsers.getInstance();

    /**
     * Inicializa una variable a -1
     * Entra en un bucle mientras la variable sea diferente de 7
     * Dentro del bucle llama al metodo chooseOption para que el usuario elija una opcion
     * Luego pasa la opcion por manejarOpcionMenu para manejar la lógica correspondiente
     */
    public void start() {
        int option = -1;
        do{
            option = mainView.chooseOption();
            manejarOpcionMenu(option);
        }while(option!=7);
    }

    /**
     * Método para manejar la lógica del menú
     * Se Utiliza un switch para evaluar la opción y ejecutar la lógica asociada con esa opción.
     * Cada caso del switch corresponde a una opción del menú y llama a un método específico de la vista correspondiente
     * para mostrar un mensaje o realizar una acción.
     */
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
               welcomeByeView.byeProgram();
                break;
            default:
                System.out.println("Opción no válida, por favor intente de nuevo.");
                break;
        }
    }
}