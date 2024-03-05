package MODEL;

public class Sesion {
    private static Sesion Instance;
    private User user;
    private Sesion (){}
    public static Sesion setInstance(){
        if (Instance == null){
            Instance = new Sesion();
        }
        return Instance;
    }
    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }
}
