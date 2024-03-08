
package VIEW;

import CONTROLLER.LogInController;
import INTERFACES.ILogInView;
import IO.Security;
import IO.Teclado;

import java.security.NoSuchAlgorithmException;

public class LogInView implements ILogInView {
    @Override
    public int chooseLogIn() {
        System.out.println("\t╔════════════════════════════════════════╗\t");
        System.out.println("\t║ Pulse 1 para iniciar sesión.           ║\t");
        System.out.println("\t║ Pulse 2 si desea volver al menú.       ║\t");
        return Teclado.leerEntero("\t╚════════════════════════════════════════╝\t");
    }

    @Override
    public String enterUsername() {
        return Teclado.readString("Introduce el nombre de usuario: ");
    }

    @Override
    public String enterPassword() {
        return Teclado.readString("Introduce la contraseña: ");
    }

    @Override
    public void usernamePasswordError() {
        System.out.println("Error, el nombre de usuario o la contraseña es incorrecto.");
        System.out.println("Pruebe de nuevo.");
    }

    @Override
    public void IniciarSesion() throws NoSuchAlgorithmException {
        String username = enterUsername();
        String password = Security.hashPassword(enterPassword());
        System.out.println("Iniciando sesión de " + username + "...");
    }

    @Override
    public void Error() {
        System.out.println("Porfavor, pulse 1 o 2.");
    }
}
