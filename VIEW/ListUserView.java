package VIEW;

import INTERFACES.IListUserView;
import INTERFACES.ILogInView;
import MODEL.User;

import java.util.ArrayList;
import java.util.List;

public class ListUserView implements IListUserView {
    /**
     * Lista todos los usuarios presentes en una lista proporcionada.
     *
     * @param users La lista de usuarios a listar.
     */
    @Override
    public void listUsers(List<User> users) {
        System.out.println("**********************");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("**********************");
    }

    /**
     * Muestra un mensaje cuando el repositorio de usuarios no está inicializado.
     */
    public void printMsg1() {
        System.out.println("El repositorio de usuarios no está inicializado.");
    }

    /**
     * Muestra un mensaje cuando no hay usuarios guardados.
     */
    public void printMsg2() {
        System.out.println("No hay usuarios guardados.");
    }
}