package VIEW;

import IO.Teclado;
import MODEL.Project;

public class AccessToProjectView {
    /**
     * Solicita al usuario el nombre del proyecto al que desea acceder.
     *
     * @return El proyecto especificado por el usuario.
     */
    public Project soliciteNameProject() {
        Project projectToAccess = null;

        String nameProject = enterNameProject();
        projectToAccess = new Project(nameProject, "", null, null, null);


        return projectToAccess;
    }

    /**
     * Solicita al usuario que ingrese el nombre del proyecto.
     *
     * @return El nombre del proyecto ingresado por el usuario.
     */
    public String enterNameProject() {
        return Teclado.readString("Introduce el nombre del proyecto: ");
    }


    /**
     * Muestra un mensaje de error cuando no se puede acceder al proyecto.
     */
    public void errorToAcces() {
        System.out.println("No existe ese proyecto al que quieres acceder.");
    }
}
