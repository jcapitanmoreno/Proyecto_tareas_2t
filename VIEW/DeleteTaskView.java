package VIEW;

import INTERFACES.IDeleteTaskView;
import IO.Teclado;

public class DeleteTaskView implements IDeleteTaskView {
    /**
     * Solicita al usuario que ingrese el nombre de la tarea que desea eliminar.
     *
     * @return El nombre de la tarea que se desea eliminar.
     */
    @Override
    public String taskToDelete() {
        System.out.println("Escriba el nombre de la tarea que desea borrar.");
        return Teclado.readString("Escriba \"volver\", para volver al menú.");
    }

    /**
     * Solicita al usuario que confirme si desea eliminar la tarea.
     *
     * @return La confirmación del usuario para eliminar la tarea.
     */
    @Override
    public String sureToDelete() {
        System.out.println("¿Estás seguro de querer borrar la tarea?");
        System.out.println("Escriba \"Si\", para borrar la tarea.");
        return Teclado.readString("Escriba \"No\", para cancelar.");
    }

    /**
     * Imprime un mensaje indicando que la tarea ha sido eliminada exitosamente.
     */
    public void printMsg1() {
        System.out.println("Tarea eliminada exitosamente.");
    }

    /**
     * Imprime un mensaje indicando que no se pudo eliminar la tarea porque no existe.
     */
    public void printMsg2() {
        System.out.println("No se pudo eliminar la tarea. La tarea no existe.");
    }
}