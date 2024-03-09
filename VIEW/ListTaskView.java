package VIEW;

import INTERFACES.IListTaskView;
import MODEL.Task;

import java.util.List;

public class ListTaskView implements IListTaskView {
    /**
     * Muestra una lista de tareas y sus detalles.
     * @param tasks La lista de tareas a mostrar
     */
    @Override
    public void listTask(List<Task> tasks) {
        System.out.println("**********************");
        for (Task task : tasks) {
            System.out.println(tasks);
        }
        System.out.println("**********************");
    }
}
