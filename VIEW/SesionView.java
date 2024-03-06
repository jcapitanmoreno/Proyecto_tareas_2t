package VIEW;

import INTERFACES.ISesionView;
import INTERFACES.Icontroller;
import IO.Teclado;

public class SesionView implements ISesionView {
    public Icontroller controller;
    public SesionView(Icontroller controller) {
        this.controller = controller;
    }


    @Override
    public int sesionView() {
        int opcion;
        do {
            System.out.println("\t╔══════════════════════════════════╗\t");
            System.out.println("\t║ Pulse 1 para iniciar sesión.     ║\t");
            System.out.println("\t║ Pulse 2 para crear usuario.      ║\t");
            System.out.println("\t║ Pulse 3 para cerrar el programa. ║\t");
            System.out.println("\t╚══════════════════════════════════╝\t");
            opcion = Teclado.leerEntero("Elige una opción: ");
            controller.manejarOpcionSesion(opcion);
        }while (opcion != 3);
        return opcion;
    }
}
