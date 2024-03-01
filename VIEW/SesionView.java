package VIEW;

import INTERFACES.ISesionView;
import IO.Teclado;

public class SesionView implements ISesionView {

    @Override
    public int sesionView() {
        System.out.println("\t╔══════════════════════════════════╗\t");
        System.out.println("\t║ Pulse 1 para iniciar sesión.     ║\t");
        System.out.println("\t║ Pulse 2 para crear usuario.      ║\t");
        System.out.println("\t║ Pulse 3 para cerrar el programa. ║\t");
        System.out.println("\t╚══════════════════════════════════╝\t");
        return Teclado.leerEntero("Elige una opción: ");
    }

}
