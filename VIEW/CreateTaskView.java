package VIEW;

import INTERFACES.ICreateTaskView;
import IO.StringToDate;
import IO.Teclado;
import MODEL.Task;
import MODEL.User;

import static MODEL.TaskStatus.EN_TRAMITE;

public class CreateTaskView implements ICreateTaskView {
    User user = new User("juan","Juan1","1234","juan@gmail.com");
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
                user,
                EN_TRAMITE);
        return taskCreated;
    }
}
