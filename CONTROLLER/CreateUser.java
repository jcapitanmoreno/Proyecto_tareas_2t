package CONTROLLER;

import MODEL.RepoUsers;
import MODEL.User;
import VIEW.CreateUserView;


import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class CreateUser {
    private List<User> users;
    CreateUserView createUserView = new CreateUserView();



    /**
     * Crea un nuevo usuario.
     * Solicita al usuario que introduzca los detalles del nuevo usuario mediante la vista createUserView.
     * Busca si el usuario ya existe en el repositorio de usuarios.
     * Si el usuario no existe, lo añade al repositorio y guarda los cambios.
     * @return true si el usuario fue añadido con éxito, false si no se añadió.
     * @throws NoSuchAlgorithmException si ocurre un error relacionado con el algoritmo de hash (en caso de que se use).
     */
    public boolean createUser() throws NoSuchAlgorithmException {
        boolean userAdded = false;
        User u = createUserView.createUser();        
        User existingUser = findUser(u.getUser(), u.getMail());
        RepoUsers ru = RepoUsers.getInstance();
        if (existingUser == null) {
            if (ru.add(u) != null) {
                userAdded = true;
                ru.save();
                createUserView.printMsg1();
            }
        } else {
            createUserView.errorNameUserOrEmail();
        }
        return userAdded;
    }


     /**
     * Busca un usuario en el repositorio de usuarios utilizando el nombre de usuario o el correo electrónico.
     * @param username El nombre de usuario a buscar.
     * @param email El correo electrónico del usuario a buscar.
     * @return El usuario encontrado, o null si no se encontró ningún usuario con el nombre de usuario o correo electrónico especificados.
     */
    public User findUser(String username, String email) {
        User foundUser = null;
        boolean isFound = false;
        Set<User> users = RepoUsers.getInstance().getUsers();
        Iterator<User> iterator = users.iterator();
        while (!isFound && iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUser().equals(username) || user.getMail().equals(email)) {
                foundUser = user;
                isFound = true;
            }
        }
        return foundUser;
    }


    /**
     * Valída si una dirección de correo electrónico es válida según un patrón específico.
     * @param email La dirección de correo electrónico a validar.
     * @return true si la dirección de correo electrónico es válida, false de lo contrario.
     */
    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
        return pattern.matcher(email).matches();

    }
}
