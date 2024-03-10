package VIEW;

import INTERFACES.iLogOutView;
import IO.Teclado;

public class LogOutView implements iLogOutView {
    @Override
    public String logOut() {
        System.out.println("¿Estás seguro de querer cerrar sesión?");
        System.out.println("Si. Para cerrar sesión.");
        return Teclado.readString("No. Para cancelar.");
    }
}
