package VIEW;

import INTERFACES.IDeleteTaskView;
import IO.Teclado;

public class DeleteTaskView implements IDeleteTaskView {
    @Override
    public String taskToDelete() {
        System.out.println("Escriba el nombre de la tarea que desea borrar.");
        return Teclado.readString("Escriba \"volver\", para volver al menú.");
    }

    @Override
    public String sureToDelete() {
        System.out.println("¿Estás seguro de querer borrar la tarea?");
        System.out.println("Escriba \"Si\", para borrar la tarea.");
        return Teclado.readString("Escriba \"No\", para cancelar.");
    }
}
