package VIEW;

import INTERFACES.ICreateUserView;
import IO.Teclado;
import MODEL.User;

public class CreateUserView implements ICreateUserView {
    @Override
    public String createInformation() {
        System.out.println("Para la creación de un usuario nuevo necesitamos cierta información, como puede ser:\n" +
                "tu nombre completo, \n" +
                "un usuario con el que identificarte, \n" +
                "una contraseña segura para poder iniciar sesión y \n" +
                "un correo electrónico.");
        return Teclado.readString("Escriba \"volver\" si desea volver al menú.\n" +
                "Escriba \"crear\" para crear el usuario.");
    }

    @Override
    public User createUser() {
        User userCreated = new User(Teclado.readString("Introduce tu nombre: "),
                Teclado.readString("Introduce tu usuario: "),
                Teclado.readString("Introduce la contraseña: "),
                Teclado.readString("Introduce tu correo electrónico: "));
        return userCreated;
    }
}
