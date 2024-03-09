package VIEW;

import CONTROLLER.LogInController;
import INTERFACES.ILogInView;
import IO.Security;
import IO.Teclado;
import MODEL.User;

import java.security.NoSuchAlgorithmException;

public class LogInView implements ILogInView {
    /**
     * Muestra un menú para que el usuario elija iniciar sesión o volver al menú y devuelve la opción seleccionada.
     *
     * @return La opción seleccionada por el usuario
     */
    @Override
    public int chooseLogIn() {
        System.out.println("1. Para iniciar sesión.");
        return Teclado.leerEntero(
                "2. Si desea volver al menú.");
    }

    /**
     * Hace que el usuario escriba su nombre
     *
     * @return el nombre de usuario
     */
    @Override
    public String enterUsername() {

        return Teclado.readString("Introduce el nombre de usuario: ");
    }

    /**
     * Hace que el usuario escriba su contraseña
     *
     * @return el nombre de contraseña
     */
    @Override
    public String enterPassword() {
        return Teclado.readString("Introduce la clave: ");
    }

    /**
     * Muestra un mensaje de error cuando el nombre de usuario o la contraseña es incorrecto.
     */
    @Override
    public void usernamePasswordError() {
        System.out.println("Error, el nombre de usuario o la contraseña es incorrecto.");
        System.out.println("Pruebe de nuevo.");
    }

    /**
     * Inicia sesión del usuario.
     *
     * @throws NoSuchAlgorithmException si el algoritmo de hash no está disponible
     */
    @Override
    public void IniciarSesion() throws NoSuchAlgorithmException {
        String username = enterUsername();
        String password = Security.hashPassword(enterPassword());
        System.out.println("Inicio de sesión con usuario: " + username + " y contraseña  *********:");

    }

    /**
     * Muestra un mensaje de error indicando al usuario que pulse 1 o 2.
     */
    @Override
    public void Error() {
        System.out.println("Porfavor, pulse 1 o 2.");
    }

    /**
     * Solicita y devuelve un usuario con el nombre de usuario y contraseña proporcionados.
     *
     * @return El usuario creado con el nombre de usuario y contraseña ingresados
     * @throws NoSuchAlgorithmException si el algoritmo de hash no está disponible
     */
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