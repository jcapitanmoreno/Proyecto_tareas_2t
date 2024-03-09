package VIEW;

import INTERFACES.IDeleteTaskView;
import IO.Teclado;

public class DeleteTaskView implements IDeleteTaskView {
    /**
     * Muestra un mensaje para solicitar al usuario que escriba el nombre de la tarea que desea borrar y devuelve la entrada del usuario.
     *
     * @return El nombre de la tarea a borrar o la opción de volver al menú
     */
    @Override
    public String taskToDelete() {
        System.out.println("Escriba el nombre de la tarea que desea borrar.");
        return Teclado.readString("Escriba \"volver\", para volver al menú.");
    }
    /**
     * Muestra un mensaje para confirmar si el usuario desea borrar la tarea y devuelve la entrada del usuario.
     * @return La confirmación del usuario para borrar o cancelar la tarea
     */
    @Override
    public String sureToDelete() {
        System.out.println("¿Estás seguro de querer borrar la tarea?");
        System.out.println("Escriba \"Si\", para borrar la tarea.");
        return Teclado.readString("Escriba \"No\", para cancelar.");
    }
}
