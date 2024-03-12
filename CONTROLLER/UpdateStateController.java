package CONTROLLER;

import IO.Teclado;
import MODEL.Project;
import MODEL.Task;
import MODEL.TaskStatus;
import VIEW.UpdateStateTaskView;

import java.util.List;

public class UpdateStateController {
    Project project = new Project();
    Teclado teclado = new Teclado();
    String name;
    TaskStatus newStatus;

    public void changeTaskStatusByName() {
        List<Task> tasks = project.getTasks();
        for (Task task : tasks) {
            if (task.getName().equals(name)) {
                task.setTaskStatus(newStatus);
                teclado.printMsg("El estado de la tarea ha sido cambiado a " + newStatus);
            }
        }
        teclado.printMsg("No se encontró ninguna tarea con el nombre " + name);
    }
}
