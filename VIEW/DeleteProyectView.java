package VIEW;

import INTERFACES.IDeleteProyectView;
import IO.Teclado;

public class DeleteProyectView implements IDeleteProyectView {
    /**
     * Muestra un mensaje para solicitar al usuario que escriba el nombre del proyecto que desea borrar y devuelve la entrada del usuario.
     * @return El nombre del proyecto a borrar o la opción de volver al menú
     */
    @Override
    public String proyectToDelete() {
        System.out.println("Escriba el nombre del proyecto que desea borrar.");
        return Teclado.readString("Escriba \"volver\", para volver al menú.");
    }
    /**
     * Muestra un mensaje para confirmar si el usuario desea borrar el proyecto y devuelve la entrada del usuario.
     * @return La confirmación del usuario para borrar o cancelar el borrado del proyecto
     */
    @Override
    public String sureToDelete() {
        System.out.println("¿Estás seguro de querer borrar el proyecto?");
        System.out.println("Escriba \"Si\", para borrar el proyecto.");
        return Teclado.readString("Escriba \"No\", para cancelar.");
    }
    /**
     * Muestra un mensaje indicando que se está eliminando un proyecto.
     */
    @Override
    public void deleteProyectMsg() {
        System.out.println("Eliminando proyecto ...");
    }
}

