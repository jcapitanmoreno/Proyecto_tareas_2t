package VIEW;

import INTERFACES.IListUserView;
import INTERFACES.ILogInView;
import MODEL.User;

import java.util.ArrayList;
import java.util.List;

public class ListUserView implements IListUserView {

    @Override
    public void listUsers(List<User> users) {
        System.out.println("**********************");
        for (User user : users) {
            System.out.println(user);
        }
        System.out.println("**********************");
    }
    public void printMsg1(){
        System.out.println("El repositorio de usuarios no está inicializado.");
    }
    public void printMsg2(){
        System.out.println("No hay usuarios guardados.");
    }
}
