package VIEW;

import CONTROLLER.CreateUser;
import INTERFACES.ICreateUserView;
import IO.Security;
import IO.Teclado;
import MODEL.User;

import java.security.NoSuchAlgorithmException;

public class CreateUserView implements ICreateUserView {
    //;

    @Override
    public int wantToCreate() {
        System.out.println("\t║     1. Para crear usuario.          ║\t");
        return Teclado.leerEntero("\t║     2. Si desea volver al menú.     ║\t");
    }

    @Override
    public User createUser() throws NoSuchAlgorithmException {
        User userCreated = new User(Teclado.readString("Introduce un nombre: "),
                Teclado.readString("Introduce un usuario: "),
                Security.hashPassword(Teclado.readString("Introduce una contraseña: ")),
                createEmail());
        return userCreated;
    }
    
    public String createEmail() {
        String email;
        CreateUser createUser = new CreateUser();
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
@Override
public void errorNameUserOrEmail(){
    System.out.println("El nombre de usuario o correo electrónico ya está en uso. Por favor, elige otro.");
}

}


