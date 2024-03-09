package CONTROLLER;

import MODEL.RepoUsers;
import MODEL.User;
import VIEW.CreateUserView;

import javax.swing.text.View;
import java.util.Iterator;
import java.util.List;

public class CreateUser {
    private List<User> users;

    /**
     * Este método interactúa con la vista para obtener los datos de un nuevo usuario
     * agrega el usuario al repositorio de usuarios y luego imprime el resultado de la operación de guardado.
     * @return true si el usuario se agregó correctamente al repositorio, de lo contrario false.
     *
     */

    public boolean createUser() {
        CreateUserView view = new CreateUserView();
        boolean userAdded = false;
        User u = view.createUser();
        RepoUsers ru = RepoUsers.getInstance();
        ru.add(u);
        if (ru.add(u)!=null) {
            userAdded = true;

        }
        System.out.println(ru.save());
        return userAdded;

    }



    /**
     * Busca y elimina un usuario específico de una colección de usuarios utilizando un Iterator.
     * @param u El usuario a eliminar
     * @return El usuario eliminado, o null si no se encontró un usuario correspondiente
     */
    //funcion con iterador para la rubrica
    public User removeUser(User u){
        User userToRemove = null;
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User temporalUser = iterator.next();
            if (temporalUser.equals(u)){
                userToRemove = temporalUser;
                iterator.remove();
            }
        }
        return userToRemove;
    }


}
