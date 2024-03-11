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

    @Override
    public Project add(Project p) {
        Project result;
        if (!projects.contains(p)) {
            projects.add(p);
        }
        result = p;
        return result;
    }

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

    @Override
    public Collection<Project> getAll() {
        return projects;
    }

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
        boolean result = false;
        Project project = getByName(p);
        if (project != null){
            projects.remove(project);
            result = true;
        }
            return result;
    }

    public boolean save() {
        return super.save(FILENAME);
    }

    public static RepoProject load() {
        return Serializator.desearize(FILENAME);
    }

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

    @Override
    public String toString() {
        return "RepoProject{" +
                ", projects=" + projects +
                '}';
    }

    public boolean isProjectExist(Project project) {
        return projects.contains(project);
    }

    public Task addTaskToProject(String projectName, Task task) {
        Project project = getByName(projectName);
        boolean result = false;

        if (project != null) {
            project.addTask(task);
            // Actualiza el proyecto en el repositorio añadiendo esa tarea
            update(project);
            result = true;
        } else {
            // sacaria un mensaje que diria algo como "el proyecto no existe en el repositorio"
            result = false;
        }
        return task;
    }

    public List<Task> getTasks() {
        List<Task> allTasks = new ArrayList<>();
        for (Project project : projects) {
            allTasks.addAll(project.getTasks());
        }
        return allTasks;
    }

    public boolean access(Project p){
        boolean access = false;
        for(Project project : projects){
            if(p.equals(project)){
                access=true;
                break;
            }
        }
        return access;
    }

}