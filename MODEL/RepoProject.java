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

    public static RepoProject get_Instance() {
        if (_instance == null) {
            _instance = (RepoProject) load(FILENAME);
            if (_instance == null) {
                    _instance = new RepoProject();
            }
        }
        return _instance;
    }
    @Override
    public Project add(Project p) {
        Project result;
        if (!projects.contains(p)){
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
            if (project.getProjectCreator().equals(name)) {
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
        return projects.remove(getByName(p));
    }

    public boolean save() {
        return super.save(FILENAME);
    }

    public static RepoProject load() {
        return Serializator.desearize(FILENAME);
    }

    public boolean crearProyecto() {
        //Crear proyecto
        CreateProyectView v = new CreateProyectView();
        Project p = v.createProyect();
        add(p);
        boolean projectAdded = false;
        createProyectView.createProyect();
        if (!projects.contains(p)) {
            projectAdded = projects.add(p);
        }
        return projectAdded;

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


}