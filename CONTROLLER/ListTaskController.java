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

    /**
     * Lista las tareas de un proyecto específico.
     * Verifica si el repositorio de proyectos no es nulo.
     * Si el repositorio es nulo, muestra un mensaje de error y termina la ejecución del método.
     * Obtiene todas las tareas del proyecto especificado.
     * Si la lista de tareas está vacía, muestra un mensaje indicando que no hay tareas.
     * Si hay tareas en la lista, muestra un mensaje de confirmación y luego imprime cada tarea.
     *
     * @param p El proyecto del cual se listarán las tareas.
     */
    public void listTask(Project p) {
        if (repoProject == null) {
            taskMenuView.printMsg1();
            return;
        }
        List<Task> tasks = repoProject.getTasks(p);
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