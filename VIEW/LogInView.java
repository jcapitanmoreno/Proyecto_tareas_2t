
package VIEW;

import CONTROLLER.LogInController;
import INTERFACES.ILogInView;
import IO.Security;
import IO.Teclado;

import java.security.NoSuchAlgorithmException;

public class LogInView implements ILogInView {
    @Override
    public String chooseLogIn() {
        System.out.println("Escriba \"iniciar\" para iniciar sesión.");
        return Teclado.readString(
                "Escriba \"volver\" si desea volver al menú.");
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
        System.out.println("Inicio de sesión con usuario: " +username + " y contraseña:" );
    }
        @Override
    public void Error(){
            System.out.println("Porfavor, escriba  \"iniciar\" o volver");
        }
}
