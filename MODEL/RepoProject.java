package MODEL;


import VIEW.CreateProyectView;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class RepoProject extends Repository<Project, String>{
    private final static String FILENAME = "repoProject.bin";
    private static RepoProject _instance;
    CreateProyectView createProyectView = new CreateProyectView();

    private List<Project> projects;


    public static RepoProject getInstance(){
        if (_instance==null){
            _instance = (RepoProject) load(FILENAME);
            if (_instance==null){

            }
        }
        return _instance;
    }
    public  Project add(Project p){
        Project result = null;
        projects.add(p);
        result = p;
        return result;
    }

    public Project getByName(String name) {
        boolean n = false;
        Project result = null;
        for (Project project: projects){
            if (project.getProjectCreator().equals(name)){
                n=true;
                result=project;

            }
        }
        return result;
    }
    public Collection<Project> getAll() {
        return projects;
    }

    public Project update(Project p) {
        Project result = null;
        result=getByName(p.getName());
        if (result!=null){
            projects.remove(result);
            projects.add(p);
            result=p;
        }
        return result;
    }
    public boolean delete(String p) {
        return projects.remove(getByName(p));
    }

    public boolean save(){
        return super.save(FILENAME);
    }

    public boolean crearProyecto() {
        //Crear proyecto
        CreateProyectView v = new CreateProyectView();
        Project p = v.createProyect();
        add(p);
        boolean projectAdded = false;
        createProyectView.createProyect();
        if (!projects.contains(p)) {
            projectAdded =projects.add(p);
        }
        return projectAdded;

    }
    public Project removeproject(Project p){
        Project projectToRemove = null;
        Iterator<Project> iterator = projects.iterator();
        while (iterator.hasNext()){
            Project temporalProject = iterator.next();
            if (temporalProject.equals(p)){
                projectToRemove = temporalProject;
                iterator.remove();
                delete(temporalProject.getName());
            }
        }
        return projectToRemove;
    }


}
