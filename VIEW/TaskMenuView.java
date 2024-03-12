package VIEW;

import INTERFACES.ITaskMenuView;
import IO.Teclado;
import MODEL.TaskStatus;

public class TaskMenuView implements ITaskMenuView {
    @Override
    public int chooseTaskOption() {
        System.out.println("\t╔═══════════════════════════════════════════════════╗\t");
        System.out.println("\t║ Pulse 1 para crear tareas.                        ║\t");
        System.out.println("\t║ Pulse 2 para listar las tareas.                   ║\t");
        System.out.println("\t║ Pulse 3 para listar las tareas según el estado.   ║\t");
        System.out.println("\t║ Pulse 4 para borrar tareas.                       ║\t");
        System.out.println("\t║ Pulse 5 para cambiar el estado de una tarea.      ║\t");
        System.out.println("\t║ Pulse 6 para volver al menu anterior.             ║\t");
        System.out.println("\t╚═══════════════════════════════════════════════════╝\t");
        return Teclado.leerEntero("Elige una opción: ");
    }

    public void errorOption(){
        System.out.println("Error al seleccionar una opción, debe ser un número comprendido entre 1 y 6.");
        System.out.println("Pruebe de nuevo.");
    }
    public String getTaskNameToUpdate() {
        System.out.println("Ingrese el nombre de la tarea que desea actualizar:");
        return Teclado.readString("Escriba \"volver\", para volver al menú.");
    }

    public TaskStatus getNewTaskStatus() {
        System.out.println("Ingrese el nuevo estado de la tarea:");
        System.out.println("1. SIN_INICIAR");
        System.out.println("2. EN_TRAMITE");
        System.out.println("3. FINALIZADA");

        int choice = Teclado.leerEntero("Elija una opción:");

        return switch (choice) {
            case 1 -> TaskStatus.SIN_INICIAR;
            case 2 -> TaskStatus.EN_TRAMITE;
            case 3 -> TaskStatus.FINALIZADA;
            default -> {
                System.out.println("Opción no válida. Se establecerá como SIN_INICIAR por defecto.");
                yield TaskStatus.SIN_INICIAR;
            }
        };
    }
}