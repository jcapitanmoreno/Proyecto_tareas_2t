package INTERFACES;

public interface ILogInView {
    int chooseLogin();
    String enterUsername();
    String enterEmail();
    String enterPassword();
    void usernameEmailError();
    void passwordError();
}
