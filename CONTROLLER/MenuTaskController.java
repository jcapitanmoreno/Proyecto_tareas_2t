package CONTROLLER;

import INTERFACES.IMenuTaskController;
import VIEW.CreateTaskView;
import VIEW.TaskMenuView;
import java.security.NoSuchAlgorithmException;

public class MenuTaskController implements IMenuTaskController {
    CreateTaskView createTaskView= new CreateTaskView();
    private TaskMenuView taskMenuView = new TaskMenuView();

    // Método para iniciar el controlador del menú de tareas
    public void start() {
        int option = -1;
        do {
            option = taskMenuView.chooseTaskOption();
            manejarOpcionMenu(option);
        } while (option != 6);
    }

    // Método para manejar la lógica del menú
    public void manejarOpcionMenu(int opcion) {
        switch (opcion) {
            case 1:
       createTaskView.createTask();
                break;
            case 2:
                // Lógica para listar tareas
                break;
            case 3:
                // Lógica para listar tareas según el estado
                break;
            case 4:
                // Lógica para borrar tareas
                break;
            case 5:
                // Lógica para cambiar el estado de una tarea
                break;
            case 6:
                // Lógica para cerrar sesión
                break;
            default:
                taskMenuView.errorOption();
                break;
        }
    }
}