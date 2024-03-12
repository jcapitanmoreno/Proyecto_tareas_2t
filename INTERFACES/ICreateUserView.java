package INTERFACES;

import MODEL.User;

import java.security.NoSuchAlgorithmException;

public interface ICreateUserView {

    int wantToCreate();
    User createUser() throws NoSuchAlgorithmException;
    void errorNameUserOrEmail();
    //void errorUsernameUser();
    //void errorPasswordUser();
    //void errorSameUsernameUser();
    //void errorSameEmailUser();
    //void errorEmail();
    String getNewEmail();
    //String createEmail();

}
