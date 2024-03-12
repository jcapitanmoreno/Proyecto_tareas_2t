package CONTROLLER;

import INTERFACES.ITaskFunctions;
import IO.Teclado;
import MODEL.Project;
import MODEL.RepoProject;
import MODEL.Task;
import MODEL.TaskStatus;
import VIEW.*;

import java.security.NoSuchAlgorithmException;


public class TaskFunctions implements ITaskFunctions {
    RepoProject repoProject = RepoProject.get_Instance();
    TaskMenuView taskMenuView = new TaskMenuView();
    CreateTaskView createTaskView = new CreateTaskView();
    ListTaskController listTaskController = new ListTaskController();
    ListByEnumController listByEnumController = new ListByEnumController();
    UpdateStateController updateStateController = new UpdateStateController();
    UpdateStateTaskView updateStateTaskView = new UpdateStateTaskView();
    Teclado teclado = new Teclado();


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
                    taskMenuView.stateChange();
                    updateStateController.changeTaskStatusByName();
                    //actualizar tarea.
                    break;
                case 6:
                    //ir a la opcion de main menu
                    break;

                default:
                    teclado.printMsg("Opción no válida, por favor intente de nuevo.");
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