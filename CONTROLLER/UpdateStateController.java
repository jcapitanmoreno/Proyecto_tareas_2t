package CONTROLLER;

import MODEL.Project;
import MODEL.RepoProject;
import MODEL.Task;
import MODEL.TaskStatus;
import VIEW.TaskMenuView;

import java.util.List;

public class UpdateStateController {
    TaskMenuView taskMenuView = new TaskMenuView();
    RepoProject repoProject = RepoProject.get_Instance();


    public void changeTaskStatusByName(Project project) {
        String name =taskMenuView.taskName();
        TaskStatus newStatus =taskMenuView.newStatus();
        List<Task> tasks = repoProject.getTasks(project);
        boolean taskFound = false;
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                task.setTaskStatus(newStatus);
                System.out.println("El estado de la tarea ha sido cambiado a " + newStatus);
                taskFound = true;
                break;
            }
        }
        if (!taskFound) {
            System.out.println("No se encontró ninguna tarea con el nombre " + name);
        }
    }
}
