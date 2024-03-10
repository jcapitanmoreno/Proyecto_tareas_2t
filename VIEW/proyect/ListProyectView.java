package VIEW.proyect;
import INTERFACES.IListProyectView;
import MODEL.Project;

import java.util.List;

public class ListProyectView implements IListProyectView {
    @Override
    public void listProyects(List<Project> proyects) {
        System.out.println("**********************");
        for (Project project : proyects) {
            System.out.println(project);
        }
        System.out.println("**********************");
    }
}
