package CONTROLLER;

import MODEL.RepoUsers;
import MODEL.User;
import VIEW.CreateUserView;


import java.util.Iterator;
import java.util.List;

public class CreateUser {
    private List<User> users;


    public boolean createUser() {
        CreateUserView view = new CreateUserView();
        boolean userAdded = false;
        User u = view.createUser();
        RepoUsers ru = RepoUsers.getInstance();
        ru.add(u);
        if (ru.add(u)!=null) {
            userAdded = true;

        }
        System.out.println(ru.save());
        return userAdded;

    }


}
