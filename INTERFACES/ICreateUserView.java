package INTERFACES;

import MODEL.User;

public interface ICreateUserView {
    int createInformation();

    User createUser();

;

    String getNewEmail();

    String createEmail();
}
