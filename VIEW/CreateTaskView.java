package VIEW;

import INTERFACES.ICreateTaskView;
import IO.StringToDate;
import IO.Teclado;
import MODEL.Session;
import MODEL.Task;
import MODEL.User;

import static MODEL.TaskStatus.EN_TRAMITE;

public class CreateTaskView implements ICreateTaskView {
    Session session = Session.getInstance();
    /**
     * Muestra información necesaria para la creación de una tarea y solicita la acción del usuario.
     * @return La acción seleccionada por el usuario
     */
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
    /**
     * Crea una nueva tarea con la información proporcionada por el usuario.
     * @return La tarea creada
     */

    /**
     * Crea una nueva tarea con la información proporcionada por el usuario.
     * @return La tarea creada
     */
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
                session.getUser(),
                EN_TRAMITE);
        return taskCreated;
    }
    /**
     * Muestra un mensaje de error cuando se intenta crear una tarea con un nombre vacío.
     */
    @Override
    public void errorTaskName() {
        System.out.println("Error, la tarea no puede tener un nombre vacío.");
        System.out.println("Pruebe de nuevo.");
        System.out.println("Puede cambiarlo en la opción de modificar tarea del menú de tareas.");
    }
    /**
     * Muestra un mensaje de error cuando se intenta crear una tarea con un nombre que ya existe.
     */
    @Override
    public void errorSameTaskName() {
        System.out.println("Error, la tarea no puede tener el mismo nombre que otra tarea.");
        System.out.println("Pruebe de nuevo.");
    }
    /**
     * Muestra un mensaje de error cuando se intenta crear una tarea con la misma fecha como inicio y límite.
     */
    @Override
    public void errorTaskDates() {
        System.out.println("Error, la tarea no puede tener la misma fecha como inicio de la misma y como límite.");
        System.out.println("Pruebe de nuevo.");
        System.out.println("Puede cambiarlo en la opción de modificar tarea del menú de tareas.");
    }
    /**
     * Muestra un mensaje de error al intentar asignar un usuario a la tarea.
     */
    @Override
    public void errorTaskUser() {
        System.out.println("Error al asignar el usuario encargado de la tarea.");
        System.out.println("Se asignará por defecto al usuario que ha iniciado la sesión.");
        System.out.println("Puede cambiarlo en la opción de modificar tarea del menú de tareas.");
    }
}
