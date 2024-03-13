package INTERFACES;

public interface IDeleteUserView {
    String userToDelete();
    int sureToDelete();
    void deleteUserMsg();

    void errordeleteUserMsg();
}
