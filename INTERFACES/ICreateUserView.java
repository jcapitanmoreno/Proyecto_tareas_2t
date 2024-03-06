package INTERFACES;

import MODEL.User;

public interface ICreateUserView {
    String createInformation();
    User createUser();
    void errorNameUser();
    void errorUsernameUser();
    void errorPasswordUser();
    void errorSameUsernameUser();
    void errorSameEmailUser();
    void errorEmail();
}
