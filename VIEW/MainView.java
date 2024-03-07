package VIEW;

import INTERFACES.IMainView;
import INTERFACES.Icontroller;
import IO.Teclado;

public class MainView implements IMainView {

    public int chooseOption() {
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

    public void errorOption(){
        System.out.println("Error al seleccionar una opción, debe ser un número comprendido entre 1 y 7.");
        System.out.println("Pruebe de nuevo.");
    }


    @Override
    public void listProyectMsg() {
        System.out.println("Listando proyectos ...");
    }


    @Override
    public void listUserMsg() {
        System.out.println("Listando usuarios ...");
    }


    @Override
    public void createProyectMsg() {
        System.out.println("Creando proyectos ...");
    }


    @Override
    public void accessToProyectMsg() {
        System.out.println("Accediendo al proyecto ...");
    }
    @Override
    public void logOutMsg() {
        System.out.println("Cerrando sesión ...");
    }
}

