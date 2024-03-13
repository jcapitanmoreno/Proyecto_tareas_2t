package CONTROLLER;

import IO.Teclado;
import MODEL.Project;
import MODEL.RepoProject;
import MODEL.Task;
import MODEL.TaskStatus;
import VIEW.TaskMenuView;

import java.util.List;

public class UpdateStateController {
    TaskMenuView taskMenuView = new TaskMenuView();
    RepoProject repoProject = RepoProject.get_Instance();
    Teclado teclado = new Teclado();

    /**
     * Método para cambiar el estado de una tarea por su nombre en un proyecto dado.
     *
     * @param project El proyecto en el que se busca la tarea.
     */
    public void changeTaskStatusByName(Project project) {
        String name = taskMenuView.taskName();
        TaskStatus newStatus = taskMenuView.newStatus();
        List<Task> tasks = repoProject.getTasks(project);
        boolean taskFound = false;
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                task.setTaskStatus(newStatus);
                teclado.printMsg("El estado de la tarea ha sido cambiado a " + newStatus);
                taskFound = true;
                break;
            }
        }
        if (!taskFound) {
            teclado.printMsg("No se encontró ninguna tarea con el nombre " + name);
        }
    }
}
