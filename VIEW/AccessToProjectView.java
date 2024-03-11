package VIEW;

import IO.Teclado;
import MODEL.Project;

public class AccessToProjectView {
    public Project soliciteNameProject(){
        Project projectToAccess = null;

        String nameProject = enterNameProject();
        projectToAccess = new Project(nameProject, "", null, null, null);


        return projectToAccess;
    }

    public static String enterNameProject() {
        return Teclado.readString("Introduce el nombre del proyecto: ");
    }
}
