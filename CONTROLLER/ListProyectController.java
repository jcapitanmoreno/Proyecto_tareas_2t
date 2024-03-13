package CONTROLLER;

import IO.Teclado;
import MODEL.Project;
import MODEL.RepoProject;

import java.util.List;

public class ListProyectController {
    private RepoProject repoProject;
    Teclado teclado = new Teclado();


    public ListProyectController() {
        this.repoProject = RepoProject.get_Instance();
    }

    public void listProjects() {
        if (repoProject == null) {
            teclado.printMsg("El repositorio de proyectos no está inicializado.");
            return;
        }

        List<Project> projects = (List<Project>) repoProject.getAll();
        if (projects.isEmpty()) {
            teclado.printMsg("No hay proyectos guardados.");
        } else {
            teclado.printMsg("Hay "+projects.size()+" Proyectos guardados:");
            for (Project project : projects) {
                System.out.println(project);
            }
        }
    }
}
