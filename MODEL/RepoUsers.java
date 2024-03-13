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

    public RepoUsers() {
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
     * Método estático para obtener una instancia única del repositorio de usuarios.
     * Utiliza el patrón Singleton.
     *
     * @return La instancia única del repositorio de usuarios.
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
     * Agrega un usuario al repositorio.
     *
     * @param u El usuario a agregar.
     * @return El usuario agregado.
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
     *
     * @param u El nombre de usuario del usuario a obtener.
     * @return El usuario encontrado, o null si no se encuentra.
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
     * Obtiene todos los usuarios del repositorio.
     *
     * @return Una colección de todos los usuarios.
     */
    @Override
    public Collection<User> getAll() {
        return users;
    }

    /**
     * Actualiza un usuario en el repositorio.
     *
     * @param u El usuario actualizado.
     * @return El usuario actualizado.
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
     * Elimina un usuario del repositorio por su nombre de usuario.
     *
     * @param u El nombre de usuario del usuario a eliminar.
     * @return true si el usuario se eliminó correctamente, false en caso contrario.
     */
    @Override
    public boolean delete(String u) {
        User userToDelete = null;
        boolean userDeleted = false;
        for (User user : users) {
            if (user.getUser().equals(u)) {
                userToDelete = user;
            }
        }
        if (getInstance().userLogin.equals(userToDelete)) {
            System.out.println("Np se puede borrar el usuario con el que está la sesión iniciada.");
        } else {
            System.out.println("Borrando usuario " + userToDelete.getUser() + " ...");
            userDeleted = users.remove(getByName(u));
        }
        return userDeleted;
    }

    /**
     * Guarda el repositorio de usuarios en un archivo.
     *
     * @return true si se guardó correctamente, false en caso contrario.
     */
    public boolean save() {
        return super.save(FILENAME);
    }

    /**
     * Carga el repositorio de usuarios desde un archivo.
     *
     * @return El repositorio de usuarios cargado.
     */
    public static RepoUsers load() {
        return Serializator.desearize(FILENAME);
    }

    /**
     * Verifica si un usuario existe en el repositorio.
     *
     * @param u El usuario a verificar.
     * @return true si el usuario existe, false en caso contrario.
     */
    public boolean isUserExist(User u) {
        return users.contains(u);
    }

    /**
     * Verifica si un usuario puede iniciar sesión en el sistema.
     *
     * @param u El usuario que intenta iniciar sesión.
     * @return true si el usuario puede iniciar sesión, false en caso contrario.
     */
    public boolean login(User u) {
        boolean login = false;
        for (User user : users) {
            if (u.equals(user)) {
                login = true;
                break;
            }
        }
        return login;
    }
}
