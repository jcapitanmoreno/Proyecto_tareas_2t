package VIEW;

import INTERFACES.IDeleteUserView;
import IO.Teclado;

public class DeleteUserView implements IDeleteUserView {
    @Override
    public String userToDelete() {
        System.out.println("\t===================================\t");
        System.out.println("\t    🔵 BORRADO DE USUARIO 🔵       \t");
        System.out.println("\t===================================\t");
        System.out.println("Por favor, introduzca el nombre de usuario que desea eliminar:");
        String userInput = Teclado.readString("O escriba \"volver\" para regresar al menú.");
        System.out.println("\t===================================\t");

        return userInput;
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

