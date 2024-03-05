package INTERFACES;

import MODEL.User;

public interface Icontroller {
    void listarProyectos();
    void listarUsuarios();
    User borrarUsuarios();
    void borrarProyecto();
    void accederProyecto();
    void cerrarSesion();
    void manejarOpcionMenu(int opcion);
}
