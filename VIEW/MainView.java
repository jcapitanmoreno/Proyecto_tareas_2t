package VIEW;

import INTERFACES.IMainView;
import IO.Teclado;

public class MainView implements IMainView {

    /**
     * Muestra las opciones disponibles para el menú principal y solicita al usuario que elija una.
     *
     * @return La opción seleccionada por el usuario.
     */
    public int chooseOption() {
        System.out.println("");
        System.out.println("\t╔═════════════════════════════════════╗\t");
        System.out.println("\t║ Pulse 1 para listar proyectos.      ║\t");
        System.out.println("\t║ Pulse 2 para listar usuarios.       ║\t");
        System.out.println("\t║ Pulse 3 para borrar usuarios.       ║\t");
        System.out.println("\t║ Pulse 4 para crear proyectos.       ║\t");
        System.out.println("\t║ Pulse 5 para borrar proyectos.      ║\t");
        System.out.println("\t║ Pulse 6 para acceder a un proyecto. ║\t");
        System.out.println("\t║ Pulse 7 para cerrar sesión.         ║\t");
        System.out.println("\t╚═════════════════════════════════════╝\t");
        return Teclado.leerEntero("Elige una opción: ");
    }

    /**
     * Imprime un mensaje de error cuando se selecciona una opción no válida.
     */
    public void errorOption() {
        System.out.println("Error al seleccionar una opción, debe ser un número comprendido entre 1 y 7.");
        System.out.println("Pruebe de nuevo.");
    }

    /**
     * Muestra un mensaje indicando que se están listando los usuarios.
     */
    @Override
    public void listUserMsg() {
        System.out.println("Listando usuarios ...");
    }

    /**
     * Muestra un mensaje indicando que se está creando un proyecto.
     */
    @Override
    public void createProyectMsg() {
        System.out.println("Creando proyectos ...");
    }

    /**
     * Muestra un mensaje indicando que se está accediendo a un proyecto.
     */
    @Override
    public void accessToProyectMsg() {
        System.out.println("Accediendo al proyecto ...");
    }

    /**
     * Muestra un mensaje indicando que se está cerrando la sesión.
     */
    @Override
    public void logOutMsg() {
        System.out.println("Cerrando sesión ...");
    }
}
