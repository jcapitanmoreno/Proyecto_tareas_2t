package VIEW;

import INTERFACES.IListTaskByStatus;
import IO.Teclado;
import MODEL.Project;
import MODEL.Task;
import MODEL.TaskStatus;

import java.util.List;

public class ListTaskByStatus implements IListTaskByStatus {
    Teclado teclado = new Teclado();

    @Override
    public int byStatus() {
        System.out.println("Elige el estado de la tarea para buscar: ");
        System.out.println("1. Sin iniciar.");
        System.out.println("2. En trámite.");
        System.out.println("3. Finalizada.");
        return IO.Teclado.leerEntero("4. Para salir");
    }
}
