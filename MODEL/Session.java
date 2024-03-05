package MODEL;

public class Session {
    private static Session _instance;
    private User user;

    private Session() {
    }

    public static Session getInstance() {
        if (_instance == null) {
            _instance = new Session();
        }
        return _instance;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }
}