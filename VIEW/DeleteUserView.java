package VIEW;

import INTERFACES.IDeleteUserView;
import IO.Teclado;

public class DeleteUserView implements IDeleteUserView {
    /**
     * Solicita al usuario que ingrese el nombre del usuario que desea eliminar.
     *
     * @return El nombre del usuario que se desea eliminar.
     */
    @Override
    public String userToDelete() {
        System.out.println("Escriba el nombre de usuario que desea borrar.");
        return Teclado.readString("Escriba \"volver\", para volver al menú.");
    }

    /**
     * Solicita al usuario que confirme si desea eliminar el usuario.
     *
     * @return La opción elegida por el usuario para eliminar o cancelar.
     */
    @Override
    public int sureToDelete() {
        System.out.println("\t╔════════════════════════════════════════════════╗\t");
        System.out.println("\t║ ¿Estás seguro de querer borrar el usuario?     ║\t");
        System.out.println("\t║ Pulse 1 para borrar el usuario.                ║\t");
        System.out.println("\t║ Pulse 2 para volver al menú.                   ║\t");
        System.out.println("\t╚════════════════════════════════════════════════╝\t");
        return Teclado.leerEntero("Elige una opción: ");
    }

    /**
     * Imprime un mensaje indicando que se está eliminando el usuario.
     */
    @Override
    public void deleteUserMsg() {
        System.out.println("Eliminando usuario ...");
    }

    /**
     * Imprime un mensaje de error indicando que el usuario no se encuentra.
     */
    @Override
    public void errordeleteUserMsg() {
        System.out.println("El usuario no se encuentra");
    }
}