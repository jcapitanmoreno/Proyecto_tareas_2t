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
    public void errorOption() {
        System.out.println("Error al seleccionar una opción, debe ser un número comprendido entre 1 y 6.");
        System.out.println("Pruebe de nuevo.");
    }
    public String taskName() {
        return Teclado.readString("Escriba el nombre de la tarea que quiere cambiarle el estado: ");
    }

    public String taskNameForColaborator(){
        return Teclado.readString("Introduce el nombre de la tarea: ");
    }

    public String userNameForColaborator(){
        return Teclado.readString("Introduce el nombre del usuario: ");
    }

    public TaskStatus newStatus() {
        TaskStatus taskStatus = null;
        System.out.println("Elige el estado de la tarea al que cambiar: ");
        System.out.println("1. Sin iniciar.");
        System.out.println("2. En trámite.");
        int option = Teclado.readNumber("3. Finalizada. ", 1, 3);
        switch (option) {
            case 1:
                    taskStatus=TaskStatus.SIN_INICIAR;
                    break;
            case 2:
                taskStatus=TaskStatus.EN_TRAMITE;
                break;
            case 3:
                taskStatus= TaskStatus.FINALIZADA;
                break;
        }
        return taskStatus;
    }
    public void printMsg1(){
        System.out.println("El repositorio de proyectos no está inicializado.");
    }
    public void printMsg2(){
        System.out.println("No hay tareas guardadas.");
    }
    public void printMsg3(){
        System.out.println("Tareas guardadas:");
    }

}