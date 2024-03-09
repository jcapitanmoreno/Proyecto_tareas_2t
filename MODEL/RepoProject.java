package MODEL;


import Serializator.Serializator;
import VIEW.CreateProyectView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class RepoProject extends Repository<Project, String> {
    private final static String FILENAME = "repoProject.bin";
    private static RepoProject _instance;
    CreateProyectView createProyectView = new CreateProyectView();

    private List<Project> projects;

    public RepoProject() {
        this.projects = new ArrayList<>();
    }
    /**
     * Obtiene una instancia de RepoProject.
     * @return La instancia de RepoProject
     */
    public static RepoProject get_Instance() {
        if (_instance == null) {
            _instance = (RepoProject) load(FILENAME);
            if (_instance == null) {
                    _instance = new RepoProject();
            }
        }
        return _instance;
    }
    /**
     * Agrega un proyecto a la lista de proyectos.
     * @param p El proyecto a agregar
     * @return El proyecto agregado
     */
    @Override
    public Project add(Project p) {
        Project result;
        if (!projects.contains(p)){
            projects.add(p);
        }
        result = p;
        return result;
    }
    /**
     * Obtiene un proyecto por su nombre de creador.
     * @param name El nombre del creador del proyecto
     * @return El proyecto con el nombre de creador especificado, o null si no se encontró
     */
    @Override
    public Project getByName(String name) {
        boolean n = false;
        Project result = null;
        for (Project project : projects) {
            if (project.getProjectCreator().equals(name)) {
                n = true;
                result = project;

            }
        }
        return result;
    }
    /**
     * Obtiene todos los proyectos.
     * @return Una colección de todos los proyectos
     */
    @Override
    public Collection<Project> getAll() {
        return projects;
    }
    /**
     * Actualiza un proyecto en la lista de proyectos.
     * @param p El proyecto con los datos actualizados
     * @return El proyecto actualizado, o null si el proyecto no se encontró
     */
    @Override
    public Project update(Project p) {
        Project result = null;
        result = getByName(p.getName());
        if (result != null) {
            projects.remove(result);
            projects.add(p);
            result = p;
        }
        return result;
    }

    @Override
    public boolean delete(String p) {
        return projects.remove(getByName(p));
    }

    public boolean save() {
        return super.save(FILENAME);
    }

    public static RepoProject load() {
        return Serializator.desearize(FILENAME);
    }
    /**
     * Elimina un proyecto de la lista de proyectos.
     * @param p El proyecto a eliminar
     * @return El proyecto eliminado, o null si el proyecto no se encontró
     */
    public Project removeproject(Project p) {
        Project projectToRemove = null;
        Iterator<Project> iterator = projects.iterator();
        while (iterator.hasNext()) {
            Project temporalProject = iterator.next();
            if (temporalProject.equals(p)) {
                projectToRemove = temporalProject;
                iterator.remove();
            }
        }
        return projectToRemove;
    }


}