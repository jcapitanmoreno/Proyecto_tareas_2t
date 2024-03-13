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
    public int sureToDelete() {
        System.out.println("\t╔════════════════════════════════════════════════╗\t");
        System.out.println("\t║ ¿Estás seguro de querer borrar el usuario?     ║\t");
        System.out.println("\t║ Pulse 1 para borrar el usuario.                ║\t");
        System.out.println("\t║ Pulse 2 para volver al menú.                   ║\t");
        System.out.println("\t╚════════════════════════════════════════════════╝\t");
        return Teclado.leerEntero("Elige una opción: ");
    }

    @Override
    public void deleteUserMsg() {
            System.out.println("Eliminando usuario ...");
    }
    @Override
    public void errordeleteUserMsg(){
        System.out.println("El usuario no se encuentra");
    }
}

