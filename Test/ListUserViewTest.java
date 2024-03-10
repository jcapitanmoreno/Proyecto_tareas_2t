package Test;

import MODEL.User;
import VIEW.User.ListUserView;

import java.util.ArrayList;
import java.util.List;

public class ListUserViewTest {
    static ListUserView listuser = new ListUserView();

    public static void main(String[] args) {
        // Crear una lista de usuarios
        List<User> users = new ArrayList<>();

        // Aquí puedes agregar usuarios a la lista
        users.add(new User("juan","Juan1","1234","juan@gmail.com"));
        users.add(new User("antonio","anto12","alumno.1","antonio123@gmail.com"));

        listuser.listUsers(users);
    }
}
