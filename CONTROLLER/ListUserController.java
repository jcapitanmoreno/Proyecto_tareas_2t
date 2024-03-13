package CONTROLLER;


import IO.Teclado;
import MODEL.RepoUsers;
import MODEL.User;

import java.util.ArrayList;
import java.util.List;

public class ListUserController {
    private RepoUsers repoUser;
    Teclado teclado = new Teclado();

    public ListUserController() {
        this.repoUser = RepoUsers.getInstance();
    }

    public void listUser() {
        if (repoUser == null) {
            teclado.printMsg("El repositorio de usuarios no está inicializado.");
            return;
        }

        List<User> users = new ArrayList<>(repoUser.getAll()); // Convierte el conjunto a lista
        if (users.isEmpty()) {
            teclado.printMsg("No hay usuarios guardados.");
        } else {
            teclado.printMsg("Hay "+users.size()+" Usuarios guardados:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}