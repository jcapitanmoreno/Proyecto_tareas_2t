package VIEW;

import INTERFACES.ICreateProyectView;
import INTERFACES.IListProyectView;
import IO.Teclado;
import MODEL.Project;
import MODEL.Session;
import MODEL.Task;
import MODEL.User;
import java.util.ArrayList;
import java.util.List;

public class CreateProyectView implements ICreateProyectView {
    Session session = Session.getInstance();
    @Override
    public Project createProyect() {
        Teclado.readString("");
        String projectName = Teclado.readString("Introduce el nombre del proyecto: ");
        String projectDescription = Teclado.readString("Introduce una descripción para el proyecto: ");
        Project proyectCreated = new Project(projectName, projectDescription, session.getUser(), new ArrayList<User>(), new ArrayList<Task>());
        return proyectCreated;
    }

    @Override
    public void errorProjectName() {
        System.out.println("Error, el proyecto no puede tener un nombre vacío.");
        System.out.println("Pruebe de nuevo.");
        System.out.println("Puede cambiarlo en la opción de modificar proyecto del menú de proyectos.");
    }

    @Override
    public void errorSameProyectName() {
        System.out.println("Error, el proyecto no puede tener el mismo nombre que otro proyecto.");
        System.out.println("Pruebe de nuevo.");
    }
    public void printProjects(List<Project> projects) {
        for (Project project : projects) {
            System.out.println("Project Name: " + project.getName());
            System.out.println("Project Creator: " + project.getProjectCreator());
            System.out.println("Other Project Details: " + project.getDescription());
            System.out.println("-----------------------------");
        }
    }
}