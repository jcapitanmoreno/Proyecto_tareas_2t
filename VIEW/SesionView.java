package VIEW;

import CONTROLLER.SesionController;
import INTERFACES.ISesionView;
import IO.Teclado;

public class SesionView implements ISesionView {
    /**
     * Muestra las opciones disponibles para la sesión y solicita al usuario que elija una.
     *
     * @return La opción seleccionada por el usuario.
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
     * Imprime un mensaje de error cuando se selecciona una opción no válida.
     */
    public void errorOption() {
        System.out.println("Error al seleccionar una opción, debe ser un número comprendido entre 1 y 3.");
        System.out.println("Pruebe de nuevo.");
    }

    /**
     * Imprime un mensaje indicando que el usuario es válido y se está accediendo al programa.
     */
    public void printMsg1() {
        System.out.println("El usuario es valido, accediendo al programa...");
    }
}
