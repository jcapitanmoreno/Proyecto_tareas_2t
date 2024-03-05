package Test;

import IO.Teclado;
import MODEL.Project;
import MODEL.Task;
import MODEL.TaskStatus;
import MODEL.User;
import VIEW.ListTaskView;
import VIEW.TaskMenuView;

import java.util.ArrayList;
import java.util.List;

import static Test.UserTest.user;

public class ListTaskViewTest {
    static TaskMenuView taskMenuView = new TaskMenuView();
    static ListTaskView listTaskView = new ListTaskView();
    public static void main(String[] args) {
        TaskStatus[] taskStatus = new TaskStatus[2];
        taskStatus[0] = TaskStatus.SIN_INICIAR;
        taskStatus[1] = TaskStatus.EN_TRAMITE;
        taskStatus[2] = TaskStatus.FINALIZADA;
        Task task = new Task("Crear modelo", "Crear modelo del programa", null, null, user, taskStatus[0]);
        List<User> users = new ArrayList<>();
        List<Task> tasks = new ArrayList<>();
        users.add(new User("juan","Juan1","1234","juan@gmail.com"));

        taskMenuView.chooseTaskOption();
        IO.Teclado.pressEnter();
        listTaskView.listTask(tasks);
    }
}
