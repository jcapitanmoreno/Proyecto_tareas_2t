package CONTROLLER;

import MODEL.RepoUsers;
import MODEL.User;
import VIEW.CreateUserView;


import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CreateUser {
    private List<User> users;
    CreateUserView createUserView = new CreateUserView();



    public boolean createUser() throws NoSuchAlgorithmException {
        CreateUserView view = new CreateUserView();

        User u = createUserView.createUser();
        User existingUser = findUser(u.getUser(), u.getMail());

        if (existingUser == null) {

            RepoUsers ru = RepoUsers.getInstance();
            if (ru.add(u) != null) {
                System.out.println(ru.save());
                return true;
            }
        } else {

            createUserView.errorNameUserOrEmail();

        }
        return false;
    }

    public User findUser(String username, String email) {
        User foundUser = null;
        boolean isFound = false;
        Set<User> users = RepoUsers.getInstance().getUsers();
        Iterator<User> iterator = users.iterator();
        while (!isFound && iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUser().equals(username) || user.getMail().equals(email)) {
                foundUser = user;
                isFound = true;
            }
        }
        return foundUser;
    }


    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        return pattern.matcher(email).matches();

    }
}
