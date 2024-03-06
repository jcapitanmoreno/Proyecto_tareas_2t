package VIEW;

import INTERFACES.IDeleteUserView;
import IO.Teclado;

public class DeleteUserView implements IDeleteUserView {
    @Override
    public String userToDelete() {
        System.out.println("Escriba el nombre de usuario que desea borrar.");
        return Teclado.readString("Escriba \"volver\", para volver al menú.");
    }

    @Override
    public String sureToDelete() {
        System.out.println("¿Estás seguro de querer borrar el usuario?");
        System.out.println("Escriba \"Si\", para borrar el usuario.");
        return Teclado.readString("Escriba \"No\", para cancelar.");
    }


    public void deleteUserMsg() {
        System.out.println("Eliminando usuario ...");
    }
}