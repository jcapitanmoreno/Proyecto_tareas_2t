package MODEL;

import VIEW.CreateTaskView;

import java.io.Serializable;
import java.util.*;

public class Project implements Serializable {

    private String name;
    private String description;
    private User projectCreator;
    private List<User> collaborators;
    private List<Task> tasks;

    public Project(String name, String description, User projectCreator, List<User> collaborators, List<Task> tasks) {
        this.name = name;
        this.description = description;
        this.projectCreator = projectCreator;
        this.collaborators = collaborators;
        this.tasks = tasks;
    }

    public List<User> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<User> collaborators) {
        this.collaborators = collaborators;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getProjectCreator() {
        return projectCreator;
    }

    public void setProjectCreator(User projectCreator) {
        this.projectCreator = projectCreator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name);
    }

    @Override
    public String toString() {
        return "╔═════════════════════════════════════╗\n" +
                String.format("║ %-5s: %-28s ║\n", "Name", name) +
                String.format("║ %-10s: %-13s ║\n", "Creador del Proyecto", projectCreator) +
                "╚═════════════════════════════════════╝\n" +
                "Descripción:" + description;
    }

    public  Task addTask(Task t){
        Task result = null;
        tasks.add(t);
        result = t;
        return result;
    }
    public Task getByName(String name) {
        Task result = null;
        for (Task task: tasks){
            if (task.getName().equals(name)){
                result=task;
                break;
            }
        }
        return result;
    }
    public List<Task> getByStatus(Enum status) {
        List<Task> result = new ArrayList<>();
        for (Task task: tasks){
            if (task.getTaskStatus().equals(status)){
                result.add(task);
            }
        }
        return result;

        //return tasks.stream().filter(d->d.getTaskStatus().equals(status)).collect(Collectors.toList());
    }
    public Collection<Task> getAll() {
        return tasks;
    }
    public Task update(Task t) {
        Task result;
        result=getByName(t.getName());
        if (result!=null){
            tasks.remove(result);
            tasks.add(t);
            result=t;
        }
        return result;
    }
    public Task removeTask(Task t){
        Task taskToRemove = null;
        Iterator<Task> iterator = tasks.iterator();
        while (iterator.hasNext()){
            Task temporalTask = iterator.next();
            if (temporalTask.equals(t)){
                taskToRemove = temporalTask;
                iterator.remove();
            }
        }
        return taskToRemove;
    }

    public boolean creartarea() {
        //Crear tarea
        CreateTaskView createTaskView= new CreateTaskView();
        CreateTaskView v = new CreateTaskView();
        Task t = v.createTask();
        addTask(t);
        boolean taskAdded = false;
        createTaskView.createTask();
        if (!tasks.contains(t)) {
            taskAdded =tasks.add(t);
        }
        return taskAdded;

    }

}
