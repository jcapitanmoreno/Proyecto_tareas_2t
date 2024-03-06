package VIEW;

import INTERFACES.ICreateProyectView;
import INTERFACES.IListProyectView;
import IO.Teclado;
import MODEL.Project;
import MODEL.Session;
import MODEL.Task;
import MODEL.User;
import java.util.ArrayList;

public class CreateProyectView implements ICreateProyectView {
    Session session = Session.getInstance();
    @Override
    public String createInformation() {
        System.out.println("Para la creación de un proyecto nuevo se necesita cierta información, como puede ser:\n" +
                "Nombre del proyecto. \n" +
                "Descripción del proyecto. \n");
        return Teclado.readString("Escriba \"crear\" para crear el proyecto." +
                "Escriba \"volver\" si desea volver al menú.\n");
    }

    @Override
    public Project createProyect() {
        String user = "";
        String Task = "";
        Project proyectCreated = new Project(Teclado.readString("Introduce el nombre del proyecto: "),
                Teclado.readString("Introduce una descripción para el proyecto: "),
                session.getUser(),
                new ArrayList<User>(),
                new ArrayList<Task>());
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
}
