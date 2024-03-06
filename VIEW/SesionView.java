package VIEW;

import CONTROLLER.SesionController;
import INTERFACES.ISesionView;
import IO.Teclado;

public class SesionView implements ISesionView {

    @Override
    public int chooseoption() {
        System.out.println("\t╔══════════════════════════════════╗\t");
        System.out.println("\t║ Pulse 1 para iniciar sesión.     ║\t");
        System.out.println("\t║ Pulse 2 para crear usuario.      ║\t");
        System.out.println("\t║ Pulse 3 para cerrar el programa. ║\t");
        System.out.println("\t╚══════════════════════════════════╝\t");
        return Teclado.leerEntero("Elige una opción: ");
    }

    public void errorOption() {
        System.out.println("Error al seleccionar una opción, debe ser un número comprendido entre 1 y 3.");
        System.out.println("Pruebe de nuevo.");
    }
}
