package MODEL;

import Serializator.Serializator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RepoUsers extends Repository<User, String> {

    private final static String FILENAME = "users.bin";
    private static RepoUsers _instance;
    private Set<User> users;

    private User user;

    private RepoUsers() {
        this.users = new HashSet<>();
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return users.remove(getByName(u));
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
    public boolean login(String u ,String c){
        boolean login=false;
         for( User user:users){
             if(user.getUser().equals(u)&& user.getPassword().equals(c)){
                 login=true;
                 break;
             }
         }
        return login;
    }
}
