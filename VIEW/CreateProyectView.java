package VIEW;

import INTERFACES.ICreateProyectView;
import INTERFACES.IListProyect;
import IO.Teclado;
import MODEL.Project;
import MODEL.Task;


public class CreateProyectView implements ICreateProyectView {
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
        /**Project proyectCreated = new Project(Teclado.readString("Introduce el nombre del proyecto: "),
                Teclado.readString("Introduce una descripción para el proyecto: "),
                Teclado.readString(user),
                Teclado.readString(user),
                Teclado.readString(Task));**/
        return null; /** proyectCreated;**/
    }
}
