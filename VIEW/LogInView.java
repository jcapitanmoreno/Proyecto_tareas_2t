package VIEW;

import INTERFACES.ILogInView;
import IO.Teclado;

public class LogInView implements ILogInView {
    @Override
    public int chooseLogIn() {
        System.out.println("*********************************");
        System.out.println("* ¿Cómo desea logearse? *");
        System.out.println("1. Con el nombre de usuario.");
        System.out.println("2. Con el email.");
        System.out.println("3. Para volver al menú");
        return Teclado.leerEntero("*********************************");
    }

    @Override
    public String enterUsername() {
        return Teclado.readString("Introduce el nombre de usuario: ");
    }

    @Override
    public String enterEmail() {
        return Teclado.readString("Introduce el email: ");
    }

    @Override
    public String enterPassword() {
        return Teclado.readString("Introduce la contraseña: ");
    }

    @Override
    public void usernameEmailError() {
        System.out.println("Error, el usuario o el email es incorrecto, por favor pruebe de nuevo: ");
    }

    @Override
    public void passwordError() {
        System.out.println("Error, la contraseña es incorrecta, por favor pruebe de nuevo: ");
    }
}
