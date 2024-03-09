package VIEW;

import INTERFACES.IDeleteUserView;
import IO.Teclado;

public class DeleteUserView implements IDeleteUserView {
    /**
     * Muestra un mensaje para solicitar al usuario que escriba el nombre de usuario que desea borrar y devuelve la entrada del usuario.
     *
     * @return El nombre de usuario a borrar o la opción de volver al menú
     */
    @Override
    public String userToDelete() {
        System.out.println("Escriba el nombre de usuario que desea borrar.");
        return Teclado.readString("Escriba \"volver\", para volver al menú.");
    }

    /**
     * Muestra un mensaje para confirmar si el usuario desea borrar el usuario y devuelve la entrada del usuario.
     *
     * @return La confirmación del usuario para borrar o cancelar el usuario
     */
    @Override
    public String sureToDelete() {
        System.out.println("¿Estás seguro de querer borrar el usuario?");
        System.out.println("Escriba \"Si\", para borrar el usuario.");
        return Teclado.readString("Escriba \"No\", para cancelar.");
    }

    @Override
    public void deleteUserMsg() {
        System.out.println("Eliminando usuario ...");
    }
}

