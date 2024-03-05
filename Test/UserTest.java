package Test;

import MODEL.User;

public class UserTest {
    public static User user = new User("Pepe", "pepe2002", "1234", "pepe@gmail.com");
    public static void main(String[] args) {
        System.out.println(user.toString());

        System.out.println(user.hashCode());
    }
}
