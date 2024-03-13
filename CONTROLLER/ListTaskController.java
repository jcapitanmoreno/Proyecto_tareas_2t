package CONTROLLER;

import IO.Teclado;
import MODEL.*;
import VIEW.ListTaskByStatus;
import VIEW.TaskMenuView;

import java.util.List;

public class ListTaskController {
    private RepoProject repoProject;
    ListTaskByStatus listTaskByStatus = new ListTaskByStatus();
    Teclado teclado = new Teclado();
    TaskMenuView taskMenuView = new TaskMenuView();



    public ListTaskController() {
        this.repoProject = RepoProject.get_Instance();
    }
    public void listTask(Project p) {
        if (repoProject==null) {
            taskMenuView.printMsg1();
            return;
        }
        List<Task> tasks = repoProject.getTasks(p);// Convierte el conjunto a lista
        if (tasks.isEmpty()) {
            taskMenuView.printMsg2();
        } else {
            taskMenuView.printMsg3();
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}