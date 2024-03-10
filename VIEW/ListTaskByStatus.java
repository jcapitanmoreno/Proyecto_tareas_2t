package VIEW;

import INTERFACES.IListTaskByStatus;

public class ListTaskByStatus implements IListTaskByStatus {
    @Override
    public int byStatus() {
        System.out.println("Elige el estado de la tarea para buscar: ");
        System.out.println("1. Sin iniciar.");
        System.out.println("2. En trámite.");
        return IO.Teclado.leerEntero("3. Finalizada.");
    }
}
