package VIEW;

import INTERFACES.iLogOutView;
import IO.Teclado;

public class LogOutView implements iLogOutView {
    /**
     * Muestra un mensaje para confirmar si el usuario desea cerrar sesión y devuelve la entrada del usuario.
     * @return La confirmación del usuario para cerrar sesión o cancelar
     */
    @Override
    public String logOut() {
        System.out.println("¿Estás seguro de querer cerrar sesión?");
        System.out.println("Si. Para cerrar sesión.");
        return Teclado.readString("No. Para cancelar.");
    }
}
