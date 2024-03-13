package VIEW;
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
    public void printMsg1(){
        System.out.println("El repositorio de proyectos no está inicializado.");
    }
    public void printMsg2(){
        System.out.println("No hay proyectos guardados.");
    }
}
