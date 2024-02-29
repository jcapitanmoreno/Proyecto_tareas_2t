package VIEW;

import INTERFACES.IMainView;
import IO.Teclado;

public class MainView implements IMainView {

    @Override
    public int mainView() {
        System.out.println("\t╔═══════════════════════════════╗\t");
        System.out.println("\t║ Pulse 1 para iniciar sesión.  ║\t");
        System.out.println("\t║ Pulse 2 para crear usuario.   ║\t");
        System.out.println("\t║Pulse 3 para cerrar el programa║\t");
        System.out.println("\t╚═══════════════════════════════╝\t");
        return Teclado.leerEntero("Elige una opción: ");
    }

}
