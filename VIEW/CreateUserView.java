package VIEW;

import CONTROLLER.CreateUser;
import INTERFACES.ICreateUserView;
import IO.Teclado;
import MODEL.User;

public class CreateUserView implements ICreateUserView {
    Teclado teclado = new Teclado();
    //;

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
        return new User(
                Teclado.readString("Introduce un nombre: "),
                Teclado.readString("Introduce un usuario: "),
                Teclado.readString("Introduce una contraseña: "),
                createEmail()
        );
    }


    public String createEmail() {
        String email;
        CreateUser createUser=new CreateUser();
        do {
            email = Teclado.readString("Introduce un correo: ");
            if (!createUser.validateEmail(email)) {
                email = getNewEmail();  // Prompt the user to enter a new email
            }
        } while (!createUser.validateEmail(email));
        return email;
}





    @Override
    public String getNewEmail() {
        return Teclado.readString("Error al validar correo, escribe un nuevo email");
    }

}
