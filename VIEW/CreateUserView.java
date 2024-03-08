package VIEW;

import INTERFACES.ICreateUserView;
import IO.Teclado;
import MODEL.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateUserView implements ICreateUserView {
    @Override
    public int createInformation() {
        System.out.println("");
        System.out.println("Para la creación de un usuario nuevo necesitamos cierta información, como puede ser:\n" +
                "-> Nombre completo. \n" +
                "-> Usuario con el que identificarte. \n" +
                "-> Una contraseña segura para poder iniciar sesión. \n" +
                "-> Un correo electrónico.");
        System.out.println("");
        System.out.println("\t╔═══════════════════════════════════════╗\t");
        System.out.println("\t║ Pulse 1 para crear usuario.           ║\t");
        System.out.println("\t║ Pulse 2 si desea volver al menú.      ║\t");
        return Teclado.leerEntero("\t╚═══════════════════════════════════════╝\t");
    }

    @Override
    public User createUser() {
        System.out.println("");
        User userCreated = new User(Teclado.readString("Introduce un nombre: "),
                Teclado.readString("Introduce un usuario: "),
                Teclado.readString("Introduce una contraseña: "),
                Teclado.readString("Introduce un correo electrónico: "));
        System.out.println("Creando usuario ...");
        System.out.println("");
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

    @Override
    public boolean validateEmail(String email) {
        // Definir la expresión regular para validar un correo electrónico
        // Compilar la expresión regular
        // Crear un objeto Matcher para la cadena proporcionada
        // Verificar si la cadena coincide con la expresión regular

        String emailRegex = "^[a-zA-Z0-9_+&-]+(?:\\.[a-zA-Z0-9_+&-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void errorOption() {
        System.out.println("Error al seleccionar una opción, debe ser un número comprendido entre 1 y 3.");
        System.out.println("Pruebe de nuevo.");
    }
}
