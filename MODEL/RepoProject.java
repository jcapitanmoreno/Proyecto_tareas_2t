package MODEL;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public class RepoProject extends Repository<Project, String>{
    private final static String FILENAME = "repoProject.bin";
    private static RepoProject _instance;

    private List<Project> projects;


    public static RepoProject getInstance(){
        if (_instance==null){
            _instance = (RepoProject) load(FILENAME);
            if (_instance==null){

            }
        }
        return _instance;
    }
    public Project add(Project p){
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
    public boolean delete(String id) {
        return projects.remove(getByName(id));
    }

    public boolean save(){
        return save(FILENAME);
    }


}
