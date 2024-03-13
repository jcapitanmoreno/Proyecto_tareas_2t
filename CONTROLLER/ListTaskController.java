package CONTROLLER;

import MODEL.*;
import VIEW.TaskMenuView;
import java.util.List;

public class ListTaskController {
    private RepoProject repoProject;
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