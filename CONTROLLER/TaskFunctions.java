package CONTROLLER;

import INTERFACES.ITaskFunctions;
import MODEL.Project;
import MODEL.RepoProject;
import VIEW.CreateTaskView;
import VIEW.TaskMenuView;
import java.security.NoSuchAlgorithmException;

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
            option  = taskMenuView.chooseTaskOption();
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
}