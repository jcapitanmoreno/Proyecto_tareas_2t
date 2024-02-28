package INTERFACES;

public interface ILogInView {
    int chooseLogIn();
    String enterUsername();
    String enterEmail();
    String enterPassword();
    void usernameEmailError();
    void passwordError();
}
