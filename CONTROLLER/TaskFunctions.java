package CONTROLLER;

import INTERFACES.ITaskFunctions;
import MODEL.Project;
import MODEL.RepoProject;
import VIEW.CreateTaskView;
import VIEW.ListTaskByStatus;
import VIEW.TaskMenuView;

import java.security.NoSuchAlgorithmException;

public class TaskFunctions implements ITaskFunctions {
    RepoProject repoProject = RepoProject.get_Instance();
    TaskMenuView taskMenuView = new TaskMenuView();
    CreateTaskView createTaskView = new CreateTaskView();
    ListTaskController listTaskController = new ListTaskController();
    ListByEnumController listByEnumController = new ListByEnumController();

    public void manejarOpcionMenuTarea(Project project) throws NoSuchAlgorithmException {
        do {
            switch (taskMenuView.chooseTaskOption()) {
                case 1:
                    //creartarea();
                    repoProject.addTaskToProject(project.getName(), createTaskView.createTask());
                    repoProject.save();
                    break;
                case 2:
                    listTaskController.listTask();
                    break;
                case 3:
                    listByEnumController.listTaskStatus();
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;

                default:
                    System.out.println("Opción no válida, por favor intente de nuevo.");
            }
        } while (taskMenuView.chooseTaskOption() != 7);


    }

    @Override
    public void start() {

    }

    @Override
    public void manejarOpcionMenu(int opcion) {

    }
    // public boolean creartarea() {
    //Crear tarea
    //   boolean taskAdded = false;
    // createTaskView.createTask();
    //if (!task.contains(task)) {
    //  taskAdded =task.add(task);
    //}
    //return taskAdded;

}