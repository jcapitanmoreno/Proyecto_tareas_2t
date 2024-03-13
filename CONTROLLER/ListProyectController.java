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
