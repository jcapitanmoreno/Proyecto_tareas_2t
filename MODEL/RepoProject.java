package MODEL;


import Serializator.Serializator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class RepoProject extends Repository<Project, String> {
    private final static String FILENAME = "repoProject.bin";
    private static RepoProject _instance;
    private Project projectToAccess;

    private List<Project> projects;

    public RepoProject() {
        this.projects = new ArrayList<>();
    }

    /**
     * Devuelve la instancia única de RepoProject.
     * Si la instancia aún no ha sido creada, intenta cargarla desde un archivo.
     * Si la carga falla o la instancia aún no existe, crea una nueva instancia de RepoProject.
     *
     * @return La instancia única de RepoProject.
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

    public void setProjectToAccess(Project project) {
        this.projectToAccess = project;
    }

    /**
     * Agrega un proyecto a la lista si no está contenido en ella.
     *
     * @param p El proyecto que se desea agregar.
     * @return El proyecto que se agregó, o null si el proyecto ya estaba en la lista.
     */
    @Override
    public Project add(Project p) {
        Project result;
        if (!projects.contains(p)) {
            projects.add(p);
        }
        result = p;
        return result;
    }

    /**
     * Obtiene un proyecto por su nombre.
     *
     * @param name El nombre del proyecto que se desea obtener.
     * @return El proyecto con el nombre especificado, o null si no se encuentra.
     */
    @Override
    public Project getByName(String name) {
        boolean n = false;
        Project result = null;
        for (Project project : projects) {
            if (project.getName().equals(name)) {
                n = true;
                result = project;

            }
        }
        return result;
    }

    /**
     * Obtiene una colección de todos los proyectos.
     *
     * @return Una colección que contiene todos los proyectos en el repositorio.
     */
    @Override
    public Collection<Project> getAll() {
        return projects;
    }

    /**
     * Actualiza un proyecto en el repositorio.
     * Busca el proyecto por su nombre y lo reemplaza con el proyecto proporcionado.
     *
     * @param p El proyecto actualizado que se desea almacenar.
     * @return El proyecto actualizado si se encontró y reemplazó en el repositorio, o null si no se encontró.
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

    /**
     * Elimina un proyecto del repositorio por su nombre.
     * Busca el proyecto por su nombre y lo elimina de la lista de proyectos.
     *
     * @param p El nombre del proyecto que se desea eliminar.
     * @return true si se eliminó correctamente, false si el proyecto no se encontró en el repositorio.
     */
    @Override
    public boolean delete(String p) {
        boolean result = false;
        Project project = getByName(p);
        if (project != null) {
            projects.remove(project);
            result = true;
        }
        return result;
    }

    /**
     * Guarda el estado actual del repositorio en un archivo.
     * Utiliza la funcionalidad de guardar heredada de la clase base.
     *
     * @return true si la operación de guardado fue exitosa, false si ocurrió algún error.
     */
    public boolean save() {
        return super.save(FILENAME);
    }


    public static RepoProject load() {
        return Serializator.desearize(FILENAME);
    }

    @Override
    public String toString() {
        return "RepoProject{" +
                ", projects=" + projects +
                '}';
    }

    /**
     * Verifica si un proyecto ya existe en el repositorio.
     * Comprueba si el proyecto dado está contenido en la lista de proyectos.
     *
     * @param project El proyecto que se desea verificar.
     * @return true si el proyecto ya existe en el repositorio, false de lo contrario.
     */
    public boolean isProjectExist(Project project) {
        return projects.contains(project);
    }

    /**
     * Agrega una tarea a un proyecto específico en el repositorio.
     * Busca el proyecto por su nombre y agrega la tarea proporcionada a ese proyecto.
     * Actualiza el proyecto en el repositorio después de agregar la tarea.
     *
     * @param projectName El nombre del proyecto al que se desea agregar la tarea.
     * @param task        La tarea que se desea agregar al proyecto.
     * @return La tarea agregada al proyecto si se pudo agregar correctamente, null si no se encontró el proyecto.
     */
    public Task addTaskToProject(String projectName, Task task) {
        Project project = getByName(projectName);
        boolean result = false;

        if (project != null) {
            project.addTask(task);
            update(project);
            result = true;
        } else {
            result = false;
        }
        return task;
    }

    /**
     * Obtiene todas las tareas de un proyecto específico en el repositorio.
     * Busca el proyecto dado y devuelve una lista de todas las tareas asociadas a ese proyecto.
     *
     * @param p El proyecto del que se desean obtener las tareas.
     * @return Una lista de todas las tareas del proyecto especificado, o una lista vacía si el proyecto no se encuentra.
     */
    public List<Task> getTasks(Project p) {
        List<Task> allTasks = new ArrayList<>();
        for (Project project : projects) {
            if (project.equals(p)) {
                allTasks.addAll(project.getTasks());
            }
        }
        return allTasks;
    }

    /**
     * Verifica si un proyecto dado tiene acceso en el repositorio.
     * Comprueba si el proyecto dado está presente en el repositorio.
     *
     * @param p El proyecto que se desea verificar si tiene acceso.
     * @return true si el proyecto tiene acceso en el repositorio, false de lo contrario.
     */
    public boolean access(Project p) {
        boolean access = false;
        for (Project project : projects) {
            if (p.equals(project)) {
                access = true;
                break;
            }
        }
        return access;
    }

    /**
     * Elimina una tarea del repositorio por su nombre.
     * Itera sobre todos los proyectos en el repositorio y elimina la tarea con el nombre especificado.
     *
     * @param taskName El nombre de la tarea que se desea eliminar.
     * @return true si la tarea fue eliminada correctamente, false si la tarea no se encontró en ningún proyecto.
     */
    public boolean deleteTask(String taskName) {
        boolean result = false;
        for (Project project : projects) {
            List<Task> tasks = project.getTasks();
            Iterator<Task> iterator = tasks.iterator();
            while (iterator.hasNext()) {
                Task task = iterator.next();
                if (task.getName().equals(taskName)) {
                    iterator.remove();
                    result = true;
                }
            }
        }
        return result;
    }
}