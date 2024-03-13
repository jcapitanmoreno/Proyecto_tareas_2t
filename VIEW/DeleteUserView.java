package VIEW;

import INTERFACES.IDeleteUserView;
import IO.Teclado;

public class DeleteUserView implements IDeleteUserView {
    @Override
    public String userToDelete() {
        System.out.println("");
        return Teclado.readString("Introduce el nombre de usuario que desea eliminar:");
    }

    public int chooseToDeleteUser() {
        System.out.println("");
        System.out.println("\t║     1. Para borrar usuario.         ║\t");
        return Teclado.leerEntero("\t║     2. Si desea volver al menú.     ║\t");
    }

    /**
     * Imprime un mensaje indicando que se está eliminando el usuario.
     */
    @Override
    public void deleteUserMsg() {
            System.out.println("Eliminando usuario ...");
    }

    @Override
    public void errordeleteUserMsg(){
        System.out.println("Por favor, introduce un número valido.");
    }
}