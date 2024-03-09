package VIEW;

import INTERFACES.IListTaskByStatus;

public class ListTaskByStatus implements IListTaskByStatus {
    /**
     * Muestra un menú para que el usuario elija el estado de la tarea para buscar y devuelve la opción seleccionada.
     *
     * @return La opción seleccionada por el usuario
     */
    @Override
    public int byStatus() {
        System.out.println("Elige el estado de la tarea para buscar: ");
        System.out.println("1. Sin iniciar.");
        System.out.println("2. En trámite.");
        return IO.Teclado.leerEntero("3. Finalizada.");
    }
}
