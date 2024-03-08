package INTERFACES;

import MODEL.User;

public interface ICreateUserView {
    int createInformation();
    User createUser();
    void errorNameUser();
    void errorUsernameUser();
    void errorPasswordUser();
    void errorSameUsernameUser();
    void errorSameEmailUser();
    void errorEmail();
    boolean validateEmail(String email);
}
