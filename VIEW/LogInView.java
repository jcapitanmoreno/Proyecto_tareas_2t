package VIEW;

import CONTROLLER.LogInController;
import INTERFACES.ILogInView;
import IO.Security;
import IO.Teclado;
import MODEL.User;

import java.security.NoSuchAlgorithmException;

public class LogInView implements ILogInView {
    @Override
    public int chooseLogIn() {
        System.out.println("1. Para iniciar sesión.");
        return Teclado.leerEntero(
                "2. Si desea volver al menú.");
    }

    @Override
    public String enterUsername() {
        return Teclado.readString("Introduce el nombre de usuario: ");
    }

    @Override
    public String enterPassword() {
        return Teclado.readString("Introduce la clave: ");
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
        System.out.println("Inicio de sesión con usuario: " + username + " y contraseña  *********:");
    }

    @Override
    public void Error() {
        System.out.println("Porfavor, pulse 1 o 2.");
    }

    @Override
    public User solicitateUser() throws NoSuchAlgorithmException {
        User usuarioAIniciar = null;

        String username = enterUsername();
        String password = Security.hashPassword(enterPassword());
        usuarioAIniciar = new User("", username, password, "");


        return usuarioAIniciar;
    }

    public void mensajeError() {
        System.out.println("Error en el inicio de sesion");
        System.out.println("pruebe otra vez");

    }

}