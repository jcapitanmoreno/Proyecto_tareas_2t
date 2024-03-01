package Test;

import IO.Teclado;
import MODEL.User;
import VIEW.ListUserView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListUserViewTest {
    static ListUserView listuser = new ListUserView();

    public static void main(String[] args) {
        // Crear una lista de usuarios
        List<User> users = new ArrayList<>();

        /** Aquí puedes agregar usuarios a la lista
         *
        users.add(new User("juan","Juan1","1234","juan@gmail.com"));
        users.add(new User("antonio","anto12","alumno.1","antonio123@gmail.com"));
         **/
        // Crear un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que ingrese los detalles del usuario
        System.out.println(" Introduce los datos del usuario: ");

        while (true) {
            System.out.println("Nombre: ");
            String name = scanner.nextLine();

            System.out.println("Nombre de Usuario: ");
            String username = scanner.nextLine();

            System.out.println("Contraseña: ");
            String password = scanner.nextLine();

            System.out.println("Correo electrónico: ");
            String email = scanner.nextLine();

            // Agregar el usuario a la lista
            users.add(new User(name, username, password, email));
            //esto para cerrar el while
            break;
        }
        listuser.listUsers(users);
    }
}
