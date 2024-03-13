package CONTROLLER;

import IO.Teclado;
import MODEL.Project;
import MODEL.RepoProject;
import VIEW.ListProyectView;

import java.util.List;

public class ListProyectController {
    private RepoProject repoProject;
    Teclado teclado = new Teclado();
    ListProyectView listProyectView = new ListProyectView();


    public ListProyectController() {
        this.repoProject = RepoProject.get_Instance();
    }
    /**
     * Lista todos los proyectos almacenados en el repositorio.
     * Verifica si el repositorio de proyectos no es nulo.
     * Si el repositorio es nulo, muestra un mensaje de error y termina la ejecución del método.
     * Obtiene todos los proyectos del repositorio.
     * Si la lista de proyectos está vacía, muestra un mensaje indicando que no hay proyectos guardados.
     * Si hay proyectos en la lista, muestra la cantidad de proyectos y luego imprime cada proyecto.
     */
    public void listProjects() {
        if (repoProject == null) {
            listProyectView.printMsg1();
            return;
        }

        List<Project> projects = (List<Project>) repoProject.getAll();
        if (projects.isEmpty()) {
            listProyectView.printMsg2();
        } else {
            teclado.printMsg("Hay "+projects.size()+" Proyectos guardados:");
            for (Project project : projects) {
                System.out.println(project);
            }
        }
    }
}
