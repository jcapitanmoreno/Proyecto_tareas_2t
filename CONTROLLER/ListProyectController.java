package CONTROLLER;

import MODEL.Project;
import MODEL.RepoProject;

import java.util.List;

public class ListProyectController {
    private RepoProject repoProject;

    public ListProyectController() {
        // Corrige el nombre del constructor
        this.repoProject = RepoProject.get_Instance();
    }

    public void listProjects() {
        // Verifica si repoProject es nulo antes de usarlo
        if (repoProject == null) {
            System.out.println("El repositorio de proyectos no está inicializado.");
            return;
        }

        List<Project> projects = (List<Project>) repoProject.getAll();
        if (projects.isEmpty()) {
            System.out.println("No hay proyectos guardados.");
        } else {
            System.out.println("Proyectos guardados:");
            for (Project project : projects) {
                System.out.println(project);
            }
        }
    }
}
