package Test;

import CONTROLLER.CreateUser;
import MODEL.User;
import VIEW.ListUserView;

import java.util.ArrayList;
import java.util.List;


public class ListUserViewTest {
    static ListUserView listuser = new ListUserView();

    public static void main(String[] args) {
        // Crear una lista de usuarios
        List<User> users = new ArrayList<>();
        //Aquí puedes agregar usuarios a la lista
        users.add(new User("","","",""));

        listuser.listUsers(users);
    }
}
