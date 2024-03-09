package VIEW;

import INTERFACES.IListUserView;
import INTERFACES.ILogInView;
import MODEL.User;

import java.util.ArrayList;
import java.util.List;

public class ListUserView implements IListUserView {
    /**
     * Muestra una lista de usuarios y sus detalles.
     *
     * @param users La lista de usuarios a mostrar
     */
    @Override
    public void listUsers(List<User> users) {
        System.out.println("**********************");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("**********************");
    }
}
