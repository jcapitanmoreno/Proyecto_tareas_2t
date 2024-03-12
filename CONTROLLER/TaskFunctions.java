package CONTROLLER;

import INTERFACES.ITaskFunctions;
import IO.Teclado;
import MODEL.Project;
import MODEL.RepoProject;
import MODEL.Task;
import MODEL.TaskStatus;
import VIEW.CreateTaskView;
import VIEW.TaskMenuView;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class TaskFunctions implements ITaskFunctions {
    RepoProject repoProject = RepoProject.get_Instance();
    TaskMenuView taskMenuView = new TaskMenuView();
    CreateTaskView createTaskView = new CreateTaskView();
    ListTaskController listTaskController = new ListTaskController();
    ListByEnumController listByEnumController = new ListByEnumController();
    DeleteTaskController deleteTaskController = new DeleteTaskController();

    public void manejarOpcionMenuTarea(Project project) throws NoSuchAlgorithmException {
        int option = -1;
        do {
            option = taskMenuView.chooseTaskOption();
            switch (option) {
                case 1:
                    repoProject.addTaskToProject(project.getName(), createTaskView.createTask());
                    repoProject.save();
                    break;
                case 2:
                    listTaskController.listTask(project);
                    break;
                case 3:
                    listByEnumController.listTaskStatus();
                    break;
                case 4:
                    deleteTaskController.deleteTask(project);
                    break;
                case 5:
                    changeTaskStatusByName(project);
                    break;
                case 6:

                    break;

                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (option != 6);
    }

    @Override
    public void start() {

    }

    @Override
    public void manejarOpcionMenu(int opcion) {

    }
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