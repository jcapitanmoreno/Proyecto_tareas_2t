package Test;

import MODEL.RepoUsers;
import MODEL.User;

public class RepoUsersTest {

    public static void main(String[] args) {
        // Crear una instancia de RepoUsers
        RepoUsers repo = RepoUsers.getInstance();

        // Crear algunos usuarios de prueba
        //User user1 = new User("usuario1", "password1");
        //User user2 = new User("usuario2", "password2");

        // Agregar los usuarios al repositorio
        //repo.add(user1);
        //repo.add(user2);

        // Comprobar si el usuario existe en el repositorio
        //System.out.println("¿El usuario1 existe? " + repo.isUserExist(user1));
        //System.out.println("¿El usuario2 existe? " + repo.isUserExist(user2));

        // Verificar credenciales
        //System.out.println("Credenciales válidas: " + repo.checkCredentials("usuario1", "password1"));
        //System.out.println("Credenciales inválidas: " + repo.checkCredentials("usuario1", "password2"));
    }
}
