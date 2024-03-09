package MODEL;

import Serializator.Serializator;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class RepoUsers extends Repository<User, String> {

    private final static String FILENAME = "users.bin";
    private static RepoUsers _instance;
    private Set<User> users;

    private User userLogin;

    private RepoUsers() {
        this.users = new HashSet<>();
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public User getUser() {
        return userLogin;
    }

    public void setUserLogin(User user) {
        this.userLogin = user;
    }
    /**
     * Obtiene una instancia de RepoUsers.
     * @return La instancia de RepoUsers
     */
    public static RepoUsers getInstance() {
        if (_instance == null) {
            _instance = (RepoUsers) load(FILENAME);
            if (_instance == null) {
                _instance = new RepoUsers();
            }
        }
        return _instance;
    }
    /**
     * Agrega un usuario a la lista de usuarios.
     * @param u El usuario a agregar
     * @return El usuario agregado, o null si el usuario ya existe en la lista
     */
    @Override
    public User add(User u) {
        User result = null;
        if (users.add(u)) {
            result = u;
        }
        return result;
    }
    /**
     * Obtiene un usuario por su nombre de usuario.
     * @param u El nombre de usuario
     * @return El usuario con el nombre de usuario especificado, o null si no se encontró
     */
    @Override
    public User getByName(String u) {
        User result = null;
        for (User user : users) {
            if (user.getUser().equals(u)) {
                result = user;
                break;
            }
        }
        return result;
    }
    /**
     * Obtiene todos los usuarios.
     * @return Una colección de todos los usuarios
     */
    @Override
    public Collection<User> getAll() {
        return users;
    }
    /**
     * Actualiza un usuario en la lista de usuarios.
     * @param u El usuario con los datos actualizados
     * @return El usuario actualizado, o null si el usuario no se encontró
     */
    @Override
    public User update(User u) {
        User result = null;
        result = getByName(u.getUser());
        if (result != null) {
            users.remove(result);
            users.add(u);
            result = u;
        }
        return result;
    }
    /**
     * Elimina un usuario de la lista de usuarios por su nombre de usuario.
     * @param u El nombre de usuario del usuario a eliminar
     * @return true si se eliminó el usuario, false si el usuario no se encontró en la lista
     */
    @Override
    public boolean delete(String u) {
        return users.remove(getByName(u));
    }
    /**
     * Guarda la instancia actual en un archivo.
     * @return true si se guardó correctamente, false si ocurrió un error
     */
    public boolean save() {
        return super.save(FILENAME);
    }

    public static RepoUsers load() {
        return Serializator.desearize(FILENAME);
    }

    public boolean isUserExist(User u) {
        return users.contains(u);
    }/**
     * Verifica si un usuario puede iniciar sesión.
     * @param u El usuario que intenta iniciar sesión
     * @return true si el usuario puede iniciar sesión, false si no puede
     */
    public boolean login(User u){
        boolean login=false;
         for( User user:users){
             if(u.equals(user)){
                 login=true;
                 break;
             }
         }
        return login;
    }
    /**
     * Establece un usuario específico en la lista de usuarios.
     * @param u El usuario a establecer
     */
    public void setUser(User u){
        for(User user : users){
            if (user.equals(u)){

            }
        }
    }
}
