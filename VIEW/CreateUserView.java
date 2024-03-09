package VIEW;

import INTERFACES.ICreateUserView;
import IO.Teclado;
import MODEL.User;

public class CreateUserView implements ICreateUserView {
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

    @Override
    public User createUser() {
        User userCreated = new User(Teclado.readString("Introduce un nombre: "),
                Teclado.readString("Introduce un usuario: "),
                Teclado.readString("Introduce una contraseña: "),
                Teclado.readString("Introduce un correo electrónico: "));
        return userCreated;
    }

    @Override
    public void errorNameUser() {
        System.out.println("Error, el usuario no puede tener un nombre vacío.");
        System.out.println("Pruebe de nuevo.");
        System.out.println("Puede cambiarlo en la opción de modificar usuario del menú de usuarios.");
    }

    @Override
    public void errorUsernameUser() {
        System.out.println("Error, el usuario no puede tener un usuario vacío.");
        System.out.println("Pruebe de nuevo.");
        System.out.println("Puede cambiarlo en la opción de modificar usuario del menú de usuarios.");
    }

    @Override
    public void errorPasswordUser() {
        System.out.println("Error, el usuario no puede tener una contraseña vacía.");
        System.out.println("Pruebe de nuevo.");
        System.out.println("Puede cambiarlo en la opción de modificar usuario del menú de usuarios.");
    }

    @Override
    public void errorSameUsernameUser() {
        System.out.println("Error, el usuario no puede tener el mismo nombre de usuario que otro usuario.");
        System.out.println("Pruebe de nuevo.");
    }

    @Override
    public void errorSameEmailUser() {
        System.out.println("Error, el usuario no puede tener el mismo email que otro usuario.");
        System.out.println("Pruebe de nuevo.");
    }

    @Override
    public void errorEmail() {
        System.out.println("El email debe contener \"@\" y \".com\" ó \".es\"");
    }
}