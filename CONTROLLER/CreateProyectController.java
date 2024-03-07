package CONTROLLER;


import MODEL.Project;
import MODEL.RepoProject;
import VIEW.CreateProyectView;


public class CreateProyectController {

    /**
     * Método para agregar un nuevo proyecto al repositorio utilizando la vista de creación.
     * - Inicializa el resultado como false.
     * - Crea una nueva instancia de la vista de creación de proyectos.
     * - Obtiene un nuevo proyecto a través de la vista.
     * - Obtiene una instancia del repositorio de proyectos utilizando el patrón Singleton.
     * - Intenta agregar el proyecto al repositorio y verifica si el resultado no es nulo.
     * - Si el proyecto se agregó correctamente, actualiza el resultado a true.
     * - Devuelve el resultado de la operación de agregado.
     *
     * @return true si el proyecto se agregó correctamente al repositorio, false en caso contrario.
     */
    public boolean addProject() {
        boolean result=false;
        CreateProyectView view = new CreateProyectView();
        Project p =view.createProyect();
        RepoProject rp = RepoProject.get_Instance();
        if(rp.add(p)!=null){
            result=true;
        }
        return result;
    }

}