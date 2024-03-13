package MODEL;

import Serializator.Serializator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RepoUsers extends Repository<User, String> {

    private final static String FILENAME = "users.bin";
    private static RepoUsers _instance;
    private Set<User> users;

    private User userLogin;

    public RepoUsers() {
        this.users = new HashSet<>();
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public User getUser() {
        return userLogin;
    }

    public void setUserLogin(User user) {
        this.userLogin = user;
    }

    public static RepoUsers getInstance() {
        if (_instance == null) {
            _instance = (RepoUsers) load(FILENAME);
            if (_instance == null) {
                _instance = new RepoUsers();
            }
        }
        return _instance;
    }

    @Override
    public User add(User u) {
        User result = null;
        if (users.add(u)) {
            result = u;
        }
        return result;
    }

    @Override
    public User getByName(String u) {
        User result = null;
        for (User user : users) {
            if (user.getUser().equals(u)) {
                result = user;
                break;
            }
        }
        return result;
    }

    @Override
    public Collection<User> getAll() {
        return users;
    }

    @Override
    public User update(User u) {
        User result = null;
        result = getByName(u.getUser());
        if (result != null) {
            users.remove(result);
            users.add(u);
            result = u;
        }
        return result;
    }

    @Override
    public boolean delete(String u) {
        User userToDelete = null;
        boolean userDeleted = false;
        for (User user : users) {
            if (user.getUser().equals(u)) {
                userToDelete = user;
            }
        }
        if (getInstance().userLogin.equals(userToDelete)) {
            System.out.println("Np se puede borrar el usuario con el que está la sesión iniciada.");
        } else{
            System.out.println("Borrando usuario " + userToDelete.getUser() + " ...");
            userDeleted = users.remove(getByName(u));
        }
        return userDeleted;
    }

    public boolean save() {
        return super.save(FILENAME);
    }

    public static RepoUsers load() {
        return Serializator.desearize(FILENAME);
    }

    public boolean isUserExist(User u) {
        return users.contains(u);
    }

    public boolean login(User u) {
        boolean login = false;
        for (User user : users) {
            if (u.equals(user)) {
                login = true;
                break;
            }
        }
        return login;
    }
}
