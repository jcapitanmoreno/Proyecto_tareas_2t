package CONTROLLER;

import INTERFACES.Icontroller;

public class Controller implements Icontroller {
    //metodos override main
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
    //metodo override sesion

    @Override
    public void iniciarSesion() {
        System.out.println("Iniciando sesión...");
    }

    @Override
    public void crearUsuario() {
        System.out.println("Creando Usuario...");
    }

    @Override
    public void cerrarPrograma() {
        System.out.println("Cerrando programa...");
    }

    //Metodo para manejar la logica del sesion
    public void manejarOpcionSesion(int opcion) {
        switch (opcion){
            case 1:
                iniciarSesion();
                break;
            case 2:
                crearUsuario();
                break;
            case 3:
                cerrarPrograma();
                break;
            default:
                System.out.println("Opción no válida, por favor intente de nuevo.");
                break;
        }
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
