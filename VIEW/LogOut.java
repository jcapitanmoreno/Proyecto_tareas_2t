package VIEW;

import INTERFACES.iLogOut;
import IO.Teclado;

public class LogOut implements iLogOut {
    @Override
    public String logOut() {
        System.out.println("¿Estás seguro de querer cerrar sesión?");
        System.out.println("Y. Para cerrar sesión.");
        return Teclado.readString("N. Para cancelar.");
    }

    @Override
    public void byeProgram() {
        System.out.println("*********************************");
        System.out.println("* Gracias por usar este programa *");
        System.out.println("*********************************");
    }
}
