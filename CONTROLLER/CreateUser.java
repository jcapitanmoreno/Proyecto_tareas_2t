package CONTROLLER;

import MODEL.RepoUsers;
import MODEL.User;
import VIEW.CreateUserView;


import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class CreateUser {
    private List<User> users;
    CreateUserView createUserView = new CreateUserView();



    public boolean createUser() throws NoSuchAlgorithmException {
        CreateUserView view = new CreateUserView();

        boolean userAdded = false;
        User u = createUserView.createUser();
        RepoUsers ru = RepoUsers.getInstance();
        if (ru.add(u) != null) {
            userAdded = true;
        }
        System.out.println(ru.save());
        return userAdded;
    }
    public User findUser(String username, String email) {
        User foundUser = null;
        boolean isFound = false;
        for (User user : this.users) {
            if (user.getUser().equals(username) || user.getMail().equals(email)) {
                foundUser = user;
                isFound = true;
            }
            if (isFound) {
                break;
            }
        }
        return foundUser;
    }


    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        return pattern.matcher(email).matches();

    }
}
