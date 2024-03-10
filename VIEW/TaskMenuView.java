package VIEW;

import INTERFACES.ITaskMenuView;
import IO.Teclado;

public class TaskMenuView implements ITaskMenuView {
    @Override
    public int chooseTaskOption() {
        System.out.println("\t╔═══════════════════════════════════════════════════╗\t");
        System.out.println("\t║ Pulse 1 para crear tareas.                        ║\t");
        System.out.println("\t║ Pulse 2 para listar las tareas.                   ║\t");
        System.out.println("\t║ Pulse 3 para listar las tareas según el estado.   ║\t");
        System.out.println("\t║ Pulse 4 para borrar tareas.                       ║\t");
        System.out.println("\t║ Pulse 5 para cambiar el estado de una tarea.      ║\t");
        System.out.println("\t║ Pulse 5 para volver al menu anterior.             ║\t");
        System.out.println("\t╚═══════════════════════════════════════════════════╝\t");
        return Teclado.leerEntero("Elige una opción: ");
    }

    public void errorOption(){
        System.out.println("Error al seleccionar una opción, debe ser un número comprendido entre 1 y 6.");
        System.out.println("Pruebe de nuevo.");
    }
}