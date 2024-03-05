package CONTROLLER;

import INTERFACES.Icontroller;
import MODEL.Project;
import MODEL.User;
import VIEW.CreateProyectView;
import VIEW.CreateUserView;

import java.util.Iterator;
import java.util.List;

public class Controller implements Icontroller {
    private List<Project> projects;
    CreateProyectView createProyectView = new CreateProyectView();
    private List<User> users;
    CreateUserView createUserView = new CreateUserView();

    public boolean crearusuarios() {
        CreateUserView v = new CreateUserView();
        boolean userAdded = false;
        createUserView.createUser();
        if (!users.contains(users)) {
            users.add(new User("","","",""));
            userAdded = true;
        }
        return userAdded;

    }
    @Override
    public void listarProyectos() {
    }
    @Override
    public void listarUsuarios() {
    }
    @Override
    public User borrarUsuarios(){
        User userToRemove = null;
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()){
            User temporalUser = iterator.next();
            if (temporalUser.equals(userToRemove)){
                iterator.remove();
            }
        }
        return userToRemove;
    }

    public boolean crearProyecto() {
        //Crear proyecto
        CreateProyectView v = new CreateProyectView();
        Project p = v.createProyect();
        //repoProject.add(p)
        boolean projectAdded = false;
        createProyectView.createProyect();
        if (!projects.contains(p)) {
            projectAdded =projects.add(p);
        }
        return projectAdded;

    }
    @Override
    public void borrarProyecto() {
        System.out.println("Borrando proyecto...");
    }

    @Override
    public void accederProyecto() {
        System.out.println("Accediendo al proyecto...");
    }

    @Override
    public void cerrarSesion() {
        System.out.println("Cerrando sesión...");
    }

    public void manejarOpcionMenu(int opcion) {
        switch (opcion) {
            case 1:
                listarProyectos();
                break;
            case 2:
                listarUsuarios();
                break;
            case 3:
                borrarUsuarios();
            case 4:
                crearProyecto();
                break;
            case 5:
                borrarProyecto();
                break;
            case 6:
                accederProyecto();
                break;
            case 7:
                cerrarSesion();
                break;
            default:
                crearusuarios();
                System.out.println("Opción no válida, por favor intente de nuevo.");
                break;
        }
    }
}
