package INTERFACES;

public interface Icontroller {
    //menu del Main
    void listarProyectos();
    void listarUsuarios();
    void borrarUsuarios();
    void crearProyecto();
    void borrarProyecto();
    void accederProyecto();
    void cerrarSesion();
    void manejarOpcionMenu(int opcion);
    //menu de inicio
    void iniciarSesion();
    void crearUsuario();
    void cerrarPrograma();
    void manejarOpcionSesion(int opcion);
}
