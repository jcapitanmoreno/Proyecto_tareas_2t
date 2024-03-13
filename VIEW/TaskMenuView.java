package VIEW;

import INTERFACES.ITaskMenuView;
import IO.Teclado;
import MODEL.TaskStatus;

public class TaskMenuView implements ITaskMenuView {
    /**
     * Muestra las opciones del menú de tareas y permite al usuario elegir una.
     *
     * @return La opción elegida por el usuario.
     */
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

    /**
     * Muestra un mensaje de error cuando se selecciona una opción incorrecta en el menú de tareas.
     */
    public void errorOption() {
        System.out.println("Error al seleccionar una opción, debe ser un número comprendido entre 1 y 6.");
        System.out.println("Pruebe de nuevo.");
    }

    /**
     * Solicita al usuario el nombre de la tarea cuyo estado desea cambiar.
     *
     * @return El nombre de la tarea proporcionado por el usuario.
     */
    public String taskName() {
        return Teclado.readString("Escriba el nombre de la tarea que quiere cambiarle el estado: ");
    }

    /**
     * Solicita al usuario seleccionar el nuevo estado para la tarea y lo devuelve.
     *
     * @return El nuevo estado seleccionado por el usuario.
     */
    public TaskStatus newStatus() {
        TaskStatus taskStatus = null;
        System.out.println("Elige el estado que desee que la tarea tenga: ");
        System.out.println("1. Sin iniciar.");
        System.out.println("2. En trámite.");
        int option = Teclado.readNumber("3. Finalizada. ", 1, 4);
        System.out.println("4. Volver al menu.");
        switch (option) {
            case 1:
                taskStatus = TaskStatus.SIN_INICIAR;
                break;
            case 2:
                taskStatus = TaskStatus.EN_TRAMITE;
                break;
            case 3:
                taskStatus = TaskStatus.FINALIZADA;
                break;
            case 4:
                chooseTaskOption();
        }
        return taskStatus;
    }

    /**
     * Imprime un mensaje indicando que el repositorio de proyectos no está inicializado.
     */
    public void printMsg1() {
        System.out.println("El repositorio de proyectos no está inicializado.");
    }

    /**
     * Imprime un mensaje indicando que no hay tareas guardadas.
     */
    public void printMsg2() {
        System.out.println("No hay tareas guardadas.");
    }

    /**
     * Imprime un mensaje indicando que se van a mostrar las tareas guardadas.
     */
    public void printMsg3() {
        System.out.println("Tareas guardadas:");
    }

    /**
     * Imprime un mensaje indicando que la opción seleccionada no es válida y solicita al usuario que lo intente de nuevo.
     */
    public void printMsg4() {
        System.out.println("Opción no válida, por favor intente de nuevo.");
    }

    /**
     * Imprime una línea vacía en la consola.
     */
    public void printMsg5() {
        System.out.println("");
    }
}