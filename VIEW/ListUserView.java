package VIEW;

import INTERFACES.IListUserView;
import INTERFACES.ILogInView;
import MODEL.User;

import java.util.ArrayList;
import java.util.List;

public class ListUserView implements IListUserView {

    @Override
    public void listUsers(List<User> user) {
        System.out.println("**********************");
        System.out.println(user);
        System.out.println("**********************");
    }
}
