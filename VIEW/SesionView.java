package VIEW;

import CONTROLLER.SesionController;
import INTERFACES.ISesionView;
import IO.Teclado;

public class SesionView implements ISesionView {
    /**
     * Muestra un menú de opciones y devuelve la opción seleccionada por el usuario.
     *
     * @return La opción seleccionada por el usuario
     */

    @Override
    public int chooseoption() {
        System.out.println("\t╔══════════════════════════════════╗\t");
        System.out.println("\t║ Pulse 1 para iniciar sesión.     ║\t");
        System.out.println("\t║ Pulse 2 para crear usuario.      ║\t");
        System.out.println("\t║ Pulse 3 para cerrar el programa. ║\t");
        System.out.println("\t╚══════════════════════════════════╝\t");
        return Teclado.leerEntero("Elige una opción: ");

    }

    /**
     * Muestra un mensaje de error cuando el usuario selecciona una opción inválida y sugiere intentarlo de nuevo.
     */
    public void errorOption() {
        System.out.println("Error al seleccionar una opción, debe ser un número comprendido entre 1 y 3.");
        System.out.println("Pruebe de nuevo.");
    }
}
