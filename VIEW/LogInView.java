
package VIEW;

import INTERFACES.ILogInView;
import IO.Teclado;

public class LogInView implements ILogInView {
    @Override
    public String chooseLogIn() {
        System.out.println("*");
        return Teclado.readString("Escriba \"iniciar\" para iniciar sesión." +
                "Escriba \"volver\" si desea volver al menú.\n");
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
}