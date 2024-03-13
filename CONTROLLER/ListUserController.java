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

    public void listUser() {
        if (repoUser == null) {
            listUserView.printMsg1();
            return;
        }

        List<User> users = new ArrayList<>(repoUser.getAll()); // Convierte el conjunto a lista
        if (users.isEmpty()) {
            listUserView.printMsg2();
        } else {
            teclado.printMsg("Hay "+users.size()+" Usuarios guardados:");
            for (User user : users) {
                System.out.println(user);
            }
        }
    }
}