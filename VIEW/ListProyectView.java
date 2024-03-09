package VIEW;

import INTERFACES.IListProyectView;
import MODEL.Project;

import java.util.List;

public class ListProyectView implements IListProyectView {
    /**
     * Muestra una lista de proyectos y sus detalles.
     *
     * @param proyects La lista de proyectos a mostrar
     */
    @Override
    public void listProyects(List<Project> proyects) {
        System.out.println("**********************");
        for (Project project : proyects) {
            System.out.println(project);
        }
        System.out.println("**********************");
    }
}
