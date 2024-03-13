package VIEW;

import CONTROLLER.CreateUser;
import INTERFACES.ICreateUserView;
import IO.Security;
import IO.Teclado;
import MODEL.User;

import java.security.NoSuchAlgorithmException;

public class CreateUserView implements ICreateUserView {
    //;

    /**
     * Solicita al usuario que elija entre crear un nuevo usuario o volver al menú.
     *
     * @return La opción seleccionada por el usuario.
     */
    @Override
    public int wantToCreate() {
        System.out.println("");
        System.out.println("\t║     1. Para crear usuario.          ║\t");
        return Teclado.leerEntero("\t║     2. Si desea volver al menú.     ║\t");
    }

    /**
     * Crea un nuevo usuario con la información proporcionada por el usuario.
     *
     * @return El usuario creado.
     * @throws NoSuchAlgorithmException sí ocurre un error al generar el hash de la contraseña.
     */

    @Override
    public User createUser() throws NoSuchAlgorithmException {
        System.out.println("");
        User userCreated = new User(Teclado.readString("Introduce un nombre: "),
                Teclado.readString("Introduce un usuario: "),
                Security.hashPassword(Teclado.readString("Introduce una contraseña: ")),
                createEmail());
        return userCreated;
    }

    /**
     * Crea un correo electrónico válido.
     *
     * @return El correo electrónico válido ingresado por el usuario.
     */
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

    /**
     * Solicita al usuario que ingrese un nuevo correo electrónico válido.
     *
     * @return El nuevo correo electrónico ingresado por el usuario.
     */
    @Override
    public String getNewEmail() {
        return Teclado.readString("Error al validar correo, escribe un nuevo email.");
    }

    /**
     * Muestra un mensaje de error cuando el nombre de usuario o correo electrónico ya está en uso.
     */
    @Override
    public void errorNameUserOrEmail() {
        System.out.println("El nombre de usuario o correo electrónico ya está en uso. Por favor, elige otro.");
    }

    /**
     * Muestra un mensaje de confirmación después de que se haya creado correctamente un usuario.
     */
    public void printMsg1() {
        System.out.println("El usuario ha sido creado correctamente. Puede continuar.");
    }

}


