package VIEW;


import INTERFACES.ILogInView;
import IO.Security;
import IO.Teclado;
import MODEL.User;

import java.security.NoSuchAlgorithmException;

public class LogInView implements ILogInView {
    /**
     * Muestra las opciones para iniciar sesión y solicita al usuario que elija una.
     *
     * @return La opción elegida por el usuario.
     */
    @Override
    public int chooseLogIn() {
        System.out.println("");
        System.out.println("\t║     1. Para iniciar sesión.         ║\t");
        return Teclado.leerEntero("\t║     2. Si desea volver al menú.     ║\t");
    }

    /**
     * Solicita al usuario que ingrese su nombre de usuario.
     *
     * @return El nombre de usuario ingresado por el usuario.
     */
    @Override
    public String enterUsername() {
        System.out.println("");
        return Teclado.readString("Introduce el nombre de usuario: ");
    }

    /**
     * Solicita al usuario que ingrese su contraseña.
     *
     * @return La contraseña ingresada por el usuario.
     */
    @Override
    public String enterPassword() {
        return Teclado.readString("Introduce la clave: ");
    }

    /**
     * Muestra un mensaje de error cuando el nombre de usuario o la contraseña son incorrectos.
     */
    @Override
    public void usernamePasswordError() {
        System.out.println("Error, el nombre de usuario o la contraseña es incorrecto.");
        System.out.println("Pruebe de nuevo.");
    }

    /**
     * Realiza el proceso de inicio de sesión, solicitando al usuario su nombre de usuario y contraseña,
     * y mostrando un mensaje de inicio de sesión exitoso.
     *
     * @throws NoSuchAlgorithmException Si no se puede realizar el hash de la contraseña.
     */
    @Override
    public void IniciarSesion() throws NoSuchAlgorithmException {
        String username = enterUsername();
        String password = Security.hashPassword(enterPassword());
        System.out.println("Inicio de sesión con usuario: " + username + " y contraseña  *********:");
    }

    /**
     * Muestra un mensaje de error cuando la opción elegida por el usuario no es válida.
     */
    @Override
    public void Error() {
        System.out.println("Por favor, pulse 1 o 2.");
    }

    /**
     * Crea un objeto de usuario con los datos ingresados por el usuario para iniciar sesión.
     *
     * @return El usuario creado con los datos ingresados para iniciar sesión.
     * @throws NoSuchAlgorithmException Si no se puede realizar el hash de la contraseña.
     */
    @Override
    public User solicitateUser() throws NoSuchAlgorithmException {
        User usuarioAIniciar = null;

        String username = enterUsername();
        String password = Security.hashPassword(enterPassword());
        usuarioAIniciar = new User("", username, password, "");

        return usuarioAIniciar;
    }

    /**
     * Muestra un mensaje de error genérico en caso de problemas durante el inicio de sesión.
     */
    public void mensajeError() {
        System.out.println("Error en el inicio de sesión");
        System.out.println("Pruebe otra vez");
    }
}