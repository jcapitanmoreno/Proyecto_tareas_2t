package VIEW;

import INTERFACES.IDeleteProyectView;
import IO.Teclado;
import MODEL.Project;

public class DeleteProyectView implements IDeleteProyectView {
    @Override
    public String proyectToDelete() {
        System.out.println("\t===================================\t");
        System.out.println("\t    🔵 BORRADO DE PROYECTO 🔵      \t");
        System.out.println("\t===================================\t");
        System.out.println("Por favor, introduzca el nombre de proyecto que desea eliminar:");
        String userInput = Teclado.readString("\t===================================\t");

        return userInput;
    }

    @Override
    public int sureToDelete() {
        System.out.println("¿Estás seguro de querer borrar el proyecto?");
        System.out.println("Pulsa 1 para borrar el proyecto.");
        return Teclado.leerEntero("Pulsa 2 para cancelar.");
    }

    @Override
    public void deleteProyectMsg(boolean result) {
        if (result){
            System.out.println("Eliminando proyecto ...");
        } else {
            System.out.println("el proyecto no ha podido ser eliminado");
        }

    }
}

