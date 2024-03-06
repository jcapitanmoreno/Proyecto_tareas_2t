package CONTROLLER;

import INTERFACES.Icontroller;
import MODEL.User;
import Serializator.Serializator;

public class Controller implements Icontroller {
    @Override
    public void listarProyectos() {
        System.out.println("Listando proyectos...");
    }

    @Override
    public void listarUsuarios() {
        System.out.println("Listando usuarios...");
    }

    @Override
    public void borrarUsuarios() {
        System.out.println("Borrando usuarios...");
    }

    @Override
    public void crearProyecto() {
        System.out.println("Creando proyecto...");
    }

    @Override
    public void borrarProyecto() {
        System.out.println("Borrando proyecto...");
    }

    @Override
    public void accederProyecto() {
        System.out.println("Accediendo al proyecto...");
    }

    @Override
    public void cerrarSesion() {
        System.out.println("Cerrando sesión...");
    }

    // Método para manejar la lógica del menú
    public void manejarOpcionMenu(int opcion) {
        switch (opcion) {
            case 1:
                listarProyectos();
                break;
            case 2:
                listarUsuarios();
                break;
            case 3:
                borrarUsuarios();
                break;
            case 4:
                crearProyecto();
                break;
            case 5:
                borrarProyecto();
                break;
            case 6:
                accederProyecto();
                break;
            case 7:
                cerrarSesion();
                break;
            default:
                System.out.println("Opción no válida, por favor intente de nuevo.");
                break;
        }
    }
}
