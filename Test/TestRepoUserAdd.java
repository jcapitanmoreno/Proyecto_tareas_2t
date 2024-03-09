package Test;

import MODEL.RepoUsers;
import MODEL.User;
import VIEW.CreateUserView;

public class TestRepoUserAdd {
    public static void main(String[] args) {
        RepoUsers repoUsers = RepoUsers.getInstance();
        CreateUserView createUserView = new CreateUserView();
        User user = createUserView.createUser();
        repoUsers.add(user);
    }
}