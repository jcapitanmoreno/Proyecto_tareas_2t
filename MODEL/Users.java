package MODEL;

public class Users<u> {
    protected String name;
    protected String user;
    private String password;
    protected String mail;

    public Users(String name, String user, String password, String mail) {
        this.name = name;
        this.user = user;
        this.password = password;
        this.mail = mail;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public String toString() {
        return "╔════════════════════════════════╗\n" +
                String.format("║ %-10s: %-20s ║\n", "Name", name) +
                String.format("║ %-10s: %-20s ║\n", "Username", user) +
                String.format("║ %-10s: %-20s ║\n", "Password", password) +
                String.format("║ %-10s: %-20s ║\n", "Email", mail) +
                "╚════════════════════════════════╝";
    }

    public void setMail(String mail) {
        this.mail = mail;

    }
}
