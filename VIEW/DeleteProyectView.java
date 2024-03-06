package VIEW;

import INTERFACES.IDeleteProyectView;
import IO.Teclado;

public class DeleteProyectView implements IDeleteProyectView {
    @Override
    public String proyectToDelete() {
        System.out.println("Escriba el nombre del proyecto que desea borrar.");
        return Teclado.readString("Escriba \"volver\", para volver al menú.");
    }

    @Override
    public String sureToDelete() {
        System.out.println("¿Estás seguro de querer borrar el proyecto?");
        System.out.println("Escriba \"Si\", para borrar el proyecto.");
        return Teclado.readString("Escriba \"No\", para cancelar.");
    }

    @Override
    public void deleteProyectMsg() {
        System.out.println("Eliminando proyecto ...");
    }
}

