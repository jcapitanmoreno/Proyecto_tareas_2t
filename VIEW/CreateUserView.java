package VIEW;

import INTERFACES.ICreateUserView;
import IO.Teclado;
import MODEL.User;

public class CreateUserView implements ICreateUserView {
    /**
     * Muestra la información necesaria para la creación de un nuevo usuario y solicita al usuario que elija una opción.
     * @return La opción elegida por el usuario
     */
    @Override
    public int createInformation() {
        System.out.println("Para la creación de un usuario nuevo necesitamos cierta información, como puede ser:\n" +
                "Nombre completo. \n" +
                "Usuario con el que identificarte. \n" +
                "Una contraseña segura para poder iniciar sesión. \n" +
                "Un correo electrónico.");
        return Teclado.leerEntero("Pulse \"1\" para crear el usuario." +
                "Escriba \"2\" si desea volver al menú.\n");
    }
    /**
     * Crea un nuevo usuario con la información proporcionada por el usuario.
     * @return El usuario creado
     */
    @Override
    public User createUser() {
        User userCreated = new User(Teclado.readString("Introduce un nombre: "),
                Teclado.readString("Introduce un usuario: "),
                Teclado.readString("Introduce una contraseña: "),
                Teclado.readString("Introduce un correo electrónico: "));
        return userCreated;
    }
    /**
     * Muestra un mensaje de error cuando se intenta crear un usuario con un nombre vacío.
     */
    @Override
    public void errorNameUser() {
        System.out.println("Error, el usuario no puede tener un nombre vacío.");
        System.out.println("Pruebe de nuevo.");
        System.out.println("Puede cambiarlo en la opción de modificar usuario del menú de usuarios.");
    }
    /**
     * Muestra un mensaje de error cuando se intenta crear un usuario con un nombre de usuario vacío.
     */
    @Override
    public void errorUsernameUser() {
        System.out.println("Error, el usuario no puede tener un usuario vacío.");
        System.out.println("Pruebe de nuevo.");
        System.out.println("Puede cambiarlo en la opción de modificar usuario del menú de usuarios.");
    }
    /**
     * Muestra un mensaje de error cuando se intenta crear un usuario con una contraseña vacía.
     */
    @Override
    public void errorPasswordUser() {
        System.out.println("Error, el usuario no puede tener una contraseña vacía.");
        System.out.println("Pruebe de nuevo.");
        System.out.println("Puede cambiarlo en la opción de modificar usuario del menú de usuarios.");
    }
    /**
     * Muestra un mensaje de error cuando se intenta crear un usuario con un nombre de usuario que ya está en uso.
     */
    @Override
    public void errorSameUsernameUser() {
        System.out.println("Error, el usuario no puede tener el mismo nombre de usuario que otro usuario.");
        System.out.println("Pruebe de nuevo.");
    }
    /**
     * Muestra un mensaje de error cuando se intenta crear un usuario con un correo electrónico que ya está en uso por otro usuario.
     */
    @Override
    public void errorSameEmailUser() {
        System.out.println("Error, el usuario no puede tener el mismo email que otro usuario.");
        System.out.println("Pruebe de nuevo.");
    }
    /**
     * Muestra un mensaje de error cuando el formato del correo electrónico introducido no es válido.
     */
    @Override
    public void errorEmail() {
        System.out.println("El email debe contener \"@\" y \".com\" ó \".es\"");
    }


}
