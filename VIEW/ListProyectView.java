package VIEW;

import INTERFACES.IListProyectView;
import MODEL.Project;

import java.util.List;

public class ListProyectView implements IListProyectView {
    /**
     * Muestra una lista de proyectos al usuario.
     *
     * @param proyects La lista de proyectos a mostrar.
     */
    @Override
    public void listProyects(List<Project> proyects) {
        System.out.println("**********************");
        for (Project project : proyects) {
            System.out.println(project);
        }
        System.out.println("**********************");
    }

    /**
     * Imprime un mensaje indicando que el repositorio de proyectos no está inicializado.
     */
    public void printMsg1() {
        System.out.println("El repositorio de proyectos no está inicializado.");
    }

    /**
     * Imprime un mensaje indicando que no hay proyectos guardados.
     */
    public void printMsg2() {
        System.out.println("No hay proyectos guardados.");
    }
}