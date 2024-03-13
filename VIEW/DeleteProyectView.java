package VIEW;

import INTERFACES.IDeleteProyectView;
import IO.Teclado;
import MODEL.Project;

public class DeleteProyectView implements IDeleteProyectView {

    /**
     * Solicita al usuario que ingrese el nombre del proyecto que desea eliminar.
     *
     * @return El nombre del proyecto que se desea eliminar.
     */
    @Override
    public String proyectToDelete() {
        return Teclado.readString("Escriba el nombre del proyecto que desea borra:.");
    }

    public int chooseToDeleteProject() {
        System.out.println("1. Para borrar proyecto.");
        return Teclado.leerEntero(
                "2. Si desea volver al menú.");
    }

    /**
     * Solicita al usuario que confirme si desea eliminar el proyecto.
     *
     * @return La confirmación del usuario para eliminar el proyecto.
     */
    @Override
    public int sureToDelete() {
        System.out.println("¿Estás seguro de querer borrar el proyecto?");
        System.out.println("Pulsa 1 para borrar el proyecto.");
        return Teclado.leerEntero("Pulsa 2 para cancelar.");
    }

    /**
     * Muestra un mensaje indicando si el proyecto ha sido eliminado correctamente o no.
     *
     * @param result Indica si el proyecto ha sido eliminado correctamente.
     */
    @Override
    public void deleteProyectMsg(boolean result) {
        if (result) {
            System.out.println("Eliminando proyecto ...");
        } else {
            System.out.println("el proyecto no ha podido ser eliminado");
        }
    }

    public void errorOptionDelete(){
        System.out.println("Por favor, introduce un número valido.");
    }
}
