package VIEW;

import INTERFACES.Icontroller;
import IO.Teclado;

public class MainView {
    private Icontroller controller;

    public MainView(Icontroller controller) {
        this.controller = controller;
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\t╔═════════════════════════════════════╗\t");
            System.out.println("\t║ Pulse 1 para listar proyectos.      ║\t");
            System.out.println("\t║ Pulse 2 para listar usuarios.       ║\t");
            System.out.println("\t║ Pulse 3 para borrar usuarios.       ║\t");
            System.out.println("\t║ Pulse 4 para crear proyectos.       ║\t");
            System.out.println("\t║ Pulse 5 para borrar proyectos.      ║\t");
            System.out.println("\t║ Pulse 6 para acceder a un proyecto. ║\t");
            System.out.println("\t║ Pulse 7 para cerrar sesión.         ║\t");
            System.out.println("\t╚═════════════════════════════════════╝\t");
            opcion = Teclado.leerEntero("Elige una opción: ");
            controller.manejarOpcionMenu(opcion);
        } while (opcion != 7);
    }
}
