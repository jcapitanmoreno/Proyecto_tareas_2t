package CONTROLLER;

import INTERFACES.ITaskFunctions;
import IO.Teclado;
import MODEL.*;
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
    UpdateStateController updateStateController = new UpdateStateController();

    /**
     * Método para manejar las opciones del menú relacionadas con las tareas.
     *
     * @param project El proyecto en el que se realizarán las operaciones.
     * @throws NoSuchAlgorithmException Si ocurre un error relacionado con el algoritmo de hash.
     */
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
                    updateStateController.changeTaskStatusByName(project);
                    repoProject.save();
                    break;
                case 6:
                    updateStateController.addColaboratorsByName(project);
                    break;
                case 7:

                    break;
                default:
                    taskMenuView.printMsg4();
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