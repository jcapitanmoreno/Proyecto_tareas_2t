package CONTROLLER;

import MODEL.User;
import VIEW.CreateUserView;

import javax.swing.text.View;
import java.util.Iterator;
import java.util.List;

public class CreateUser {
    private List<User> users;
    CreateUserView createUserView = new CreateUserView();

    public boolean createUser(User u) {
        boolean userAdded = false;
        createUserView.createUser();
        if (!users.contains(u)) {
            users.add(u);
            userAdded = true;
        }
        return userAdded;

    }

    //funcion con iterador para la rubrica
    public User revoveUser(User u){
        User userToRemove = null;
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User temporalUser = iterator.next();
            if (temporalUser.equals(u)){
                userToRemove = temporalUser;
                iterator.remove();
            }
        }
        return userToRemove;
    }


}
