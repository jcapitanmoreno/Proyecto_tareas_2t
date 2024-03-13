package CONTROLLER;


import IO.Teclado;
import MODEL.RepoUsers;
import MODEL.User;
import VIEW.ListUserView;

import java.util.ArrayList;
import java.util.List;

public class ListUserController {
    private RepoUsers repoUser;
    Teclado teclado = new Teclado();
    ListUserView listUserView = new ListUserView();

    public ListUserController() {
        this.repoUser = RepoUsers.getInstance();
    }

    /**
     * Lista todos los usuarios almacenados en el repositorio de usuarios.
     * Verifica si el repositorio de usuarios no es nulo.
     * Si el repositorio es nulo, muestra un mensaje de error y termina la ejecución del método.
     * Obtiene todos los usuarios del repositorio y los convierte en una lista.
     * Si la lista de usuarios está vacía, muestra un mensaje indicando que no hay usuarios guardados.
     * Si hay usuarios en la lista, muestra la cantidad de usuarios guardados y luego imprime cada usuario.
     */
    public void listUser() {
        if (repoUser == null) {
            listUserView.printMsg1();
            return;
        }
        List<User> users = new ArrayList<>(repoUser.getAll());
        if (users.isEmpty()) {
            listUserView.printMsg2();
        } else {
            teclado.printMsg("Hay " + users.size() + " Usuarios guardados:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}