package Test;

import VIEW.User.CreateUserView;

public class CreateUserViewTest {
    static CreateUserView createUserView = new CreateUserView();
    public static void main(String[] args) {
        createUserView.createInformation();
        createUserView.createUser();
    }
}
