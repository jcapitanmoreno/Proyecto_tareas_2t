package Test;

import VIEW.CreateUserView;

import java.security.NoSuchAlgorithmException;

public class CreateUserViewTest {
    static CreateUserView createUserView = new CreateUserView();
    public static void main(String[] args) throws NoSuchAlgorithmException {
        //createUserView.createInformation();
        createUserView.createUser();
    }
}
