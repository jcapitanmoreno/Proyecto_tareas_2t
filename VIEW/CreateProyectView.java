package VIEW;

import INTERFACES.ICreateProyectView;
import IO.Teclado;
import MODEL.Project;
import MODEL.RepoUsers;
import MODEL.Task;
import MODEL.User;

import java.util.ArrayList;
import java.util.List;

public class CreateProyectView implements ICreateProyectView {
    RepoUsers repoUsers = RepoUsers.getInstance();

    /**
     * Crea un nuevo proyecto con el nombre y la descripción especificados por el usuario.
     *
     * @return El proyecto creado.
     */
    @Override
    public Project createProyect() {
        System.out.println("");
        String projectName = Teclado.readString("Introduce el nombre del proyecto: ");
        String projectDescription = Teclado.readString("Introduce una descripción para el proyecto: ");
        Project proyectCreated = new Project(projectName, projectDescription, repoUsers.getUser(), new ArrayList<User>(), new ArrayList<Task>());
        return proyectCreated;
    }

    /**
     * Muestra un mensaje de error cuando el nombre del proyecto es inválido.
     */
    @Override
    public void errorProjectName() {
        System.out.println("Error, el proyecto no puede tener un nombre vacío.");
        System.out.println("Pruebe de nuevo.");
        System.out.println("Puede cambiarlo en la opción de modificar proyecto del menú de proyectos.");
    }

    /**
     * Muestra un mensaje de error cuando el nombre del proyecto ya existe.
     */
    @Override
    public void errorSameProyectName() {
        System.out.println("Error, el proyecto no puede tener el mismo nombre que otro proyecto.");
        System.out.println("Pruebe de nuevo.");
    }

    /**
     * Muestra las opciones disponibles para el usuario y solicita la selección de una.
     *
     * @return La opción seleccionada por el usuario.
     */
    @Override
    public int chooseoption() {
        System.out.println("");
        System.out.println("\t║     1. Para crear proyecto.         ║\t");
        return Teclado.leerEntero("\t║     2. Si desea volver al menú.     ║\t");
    }

    /**
     * Muestra un mensaje cuando el proyecto ya existe en el repositorio.
     */
    public void printMsg1() {
        System.out.println("El proyecto existe en el repositorio.");
    }

    /**
     * Muestra un mensaje cuando el proyecto se ha creado exitosamente.
     */
    public void printMsg2() {
        System.out.println("Proyecto creado exitosamente.");
    }

    /**
     * Muestra un mensaje cuando se ingresa una opción no válida.
     */
    public void printMsg3() {
        System.out.println("Opción no válida, por favor intente de nuevo.");
    }
}