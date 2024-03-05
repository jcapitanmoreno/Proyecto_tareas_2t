package VIEW;

import INTERFACES.IListProyect;
import MODEL.Project;

import java.util.List;

public class ListProyect implements IListProyect {
    @Override
    public void listProyects(List<Project> proyects) {
        System.out.println("**********************");
        for (Project project : proyects) {
            System.out.println(project);
        }
        System.out.println("**********************");
    }
}
