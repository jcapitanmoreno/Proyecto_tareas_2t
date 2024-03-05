package VIEW;

import INTERFACES.ICreateProyectView;
import IO.Teclado;
import MODEL.Project;
import MODEL.Sesion;
import MODEL.Task;
import MODEL.User;

import java.util.ArrayList;



public class CreateProyectView implements ICreateProyectView {
    Sesion sesion = Sesion.setInstance();
    @Override
    public String createInformation() {
        System.out.println("Para la creación de un proyecto nuevo se necesita cierta información, como puede ser:\n" +
                "Nombre del proyecto. \n" +
                "Descripción del proyecto. \n" +
                "Usuarios colaboradores. \n" +
                "Tareas que tendrá el proyecto.");
        return Teclado.readString("Escriba \"crear\" para crear el proyecto." +
                "Escriba \"volver\" si desea volver al menú.\n");
    }

    @Override
    public Project createProyect() {
        String user = "";
        String Task = "";
        Project proyectCreated = new Project(Teclado.readString("Introduce el nombre del proyecto: "),
                Teclado.readString("Introduce una descripción para el proyecto: "),
                sesion.getUser(),
                new ArrayList<User>(),
                new ArrayList<Task>());
        return proyectCreated;
    }
}
