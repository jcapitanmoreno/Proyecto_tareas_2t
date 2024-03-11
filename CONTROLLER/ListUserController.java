package CONTROLLER;


import MODEL.RepoUsers;
import MODEL.User;

import java.util.ArrayList;
import java.util.List;

public class ListUserController {
    private RepoUsers repoUser;

    public ListUserController() {
        this.repoUser = RepoUsers.getInstance();
    }

    public void listUser() {
        if (repoUser == null) {
            System.out.println("El repositorio de usuarios no está inicializado.");
            return;
        }

        List<User> users = new ArrayList<>(repoUser.getAll()); // Convierte el conjunto a lista
        if (users.isEmpty()) {
            System.out.println("No hay usuarios guardados.");
        } else {
            System.out.println("Usuarios guardados:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}