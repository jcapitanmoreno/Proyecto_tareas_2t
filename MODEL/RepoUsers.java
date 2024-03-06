package MODEL;

import java.util.Collection;
import java.util.Set;

public class RepoUsers extends Repository<User, String> {

    private final static String FILENAME = "users.bin";
    private static RepoUsers _instance;
    private Set<User> users;

    public static RepoUsers getInstance() {
        if (_instance == null) {
            _instance = (RepoUsers) load(FILENAME);
            if (_instance == null) {

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
        for (User user: users){
            if (user.getUser().equals(u)){
                result=user;
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
        result=getByName(u.getUser());
        if (result!=null){
            users.remove(result);
            users.add(u);
            result=u;
        }
        return result;
    }

    @Override
    public boolean delete(String u) {
        return users.remove(getByName(u));
    }
    public boolean save(){
        return super.save(FILENAME);
    }
}
