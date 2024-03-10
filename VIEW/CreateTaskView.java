package VIEW;

import INTERFACES.ICreateTaskView;
import IO.Teclado;
import MODEL.RepoUsers;
import MODEL.Task;

import static MODEL.TaskStatus.EN_TRAMITE;

public class CreateTaskView implements ICreateTaskView {
    RepoUsers repoUsers = RepoUsers.getInstance();
    @Override
    public String createInformation() {
        System.out.println("Para la creación de una tarea nueva necesitamos cierta información, como puede ser:\n" +
                "Nombre de la tarea. \n" +
                "Descripción de la tarea. \n" +
                "Fecha de inicio de la tarea. \n" +
                "Fecha límite de la tarea. \n" +
                "Colaborador encargado de la tarea. \n" +
                "Estado de la tarea.");
        return Teclado.readString("Escriba \"crear\" para crear la tarea." +
                "Escriba \"volver\" si desea volver al menú.\n");
    }

    @Override
    public Task createTask() {
        Task taskCreated = new Task(Teclado.readString("Introduce el nombre de la tarea: "),
                Teclado.readString("Introduce una descripción sobre la tarea: "),
                Teclado.readDate("Introduce la fecha de inicio de la tarea: "),
                Teclado.readDate("Introduce la fecha límite de la tarea: "),

                //Provisional que se asigne el usuario que ha iniciado sesión en la tarea creada.
                //Debe de recorrerse la lista de usuarios en un if y si el usuario introducido es igual al de alguno de la lista se asigna.
                //Si no se asigna el usuario con el else se asigna el usuario que ha iniciado sesión.
                //Luego ha de haber una opción de modificar tarea y que se pueda asignar un usuario.
                repoUsers.getUser(),
                EN_TRAMITE);
        return taskCreated;
    }

    @Override
    public void errorTaskName() {
        System.out.println("Error, la tarea no puede tener un nombre vacío.");
        System.out.println("Pruebe de nuevo.");
        System.out.println("Puede cambiarlo en la opción de modificar tarea del menú de tareas.");
    }

    @Override
    public void errorSameTaskName() {
        System.out.println("Error, la tarea no puede tener el mismo nombre que otra tarea.");
        System.out.println("Pruebe de nuevo.");
    }

    @Override
    public void errorTaskDates() {
        System.out.println("Error, la tarea no puede tener la misma fecha como inicio de la misma y como límite.");
        System.out.println("Pruebe de nuevo.");
        System.out.println("Puede cambiarlo en la opción de modificar tarea del menú de tareas.");
    }

    @Override
    public void errorTaskUser() {
        System.out.println("Error al asignar el usuario encargado de la tarea.");
        System.out.println("Se asignará por defecto al usuario que ha iniciado la sesión.");
        System.out.println("Puede cambiarlo en la opción de modificar tarea del menú de tareas.");
    }
}
