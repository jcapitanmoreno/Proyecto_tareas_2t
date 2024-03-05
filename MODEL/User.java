package MODEL;


import IO.Security;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class User implements Serializable {


    private String name;
    private String user;
    private String password;
    private String mail;

    public User(String name, String user, String password, String mail) {
        this.name = name;
        this.user = user;
        this.password = password;
        this.mail = mail;
    }

    public User(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException {
        this.password = Security.hashPassword(password);
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;

    }

    public boolean isMyPassword(String password) throws NoSuchAlgorithmException {
        return this.password.equals(Security.hashPassword(password));
    }

    @Override
    public String toString() {
        return "╔════════════════════════════════╗\n" +
                String.format("║ %-10s: %-18s ║\n", "Name", name) +
                String.format("║ %-10s: %-18s ║\n", "Username", user) +
                String.format("║ %-10s: %-18s ║\n", "Password", password) +
                String.format("║ %-10s: %-18s ║\n", "Email", mail) +
                "╚════════════════════════════════╝";
    }


    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        User user1 = (User) object;
        return Objects.equals(user, user1.user) && Objects.equals(password, user1.password);
    }
}
