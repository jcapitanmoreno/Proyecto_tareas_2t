package INTERFACES;

import MODEL.User;

import java.security.NoSuchAlgorithmException;

public interface ICreateUserView {

    int wantToCreate();
    User createUser() throws NoSuchAlgorithmException;
    String getNewEmail();
    String createEmail();
    void errorNameUserOrEmail();
}
