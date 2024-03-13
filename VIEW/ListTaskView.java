package VIEW;

import INTERFACES.IListTaskView;
import MODEL.Task;

import java.util.List;

public class ListTaskView implements IListTaskView {

    /**
     * Lista todas las tareas presentes en una lista proporcionada.
     *
     * @param tasks La lista de tareas a listar.
     */
    @Override
    public void listTask(List<Task> tasks) {
        System.out.println("**********************");
        for (Task task : tasks) {
            System.out.println(task);
        }
        System.out.println("**********************");
    }

    /**
     * Muestra un mensaje cuando se está saliendo.
     */
    public void printMsg1() {
        System.out.println("saliendo ...");
    }

    /**
     * Muestra un mensaje cuando se selecciona una opción no válida.
     */
    public void printMsg2() {
        System.out.println("Opción no válida. Elige otra opción");
    }
}