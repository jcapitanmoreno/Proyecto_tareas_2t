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

    /**@Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", ProjectCreator='" + ProjectCreator + '\'' +
                '}';
    }**/

    @Override
    public String toString() {
        return "╔═════════════════════════════════════╗\n" +
                String.format("║ %-5s: %-28s ║\n", "Name", name) +
                String.format("║ %-10s: %-13s ║\n", "Creador del Proyecto", projectCreator) +
                "╚═════════════════════════════════════╝\n" +
                "Descripción:" + description;
    }
    /**
     * Agrega una tarea a la lista de tareas.
     * @param t La tarea a agregar
     * @return La tarea agregada
     */
    public  Task addTask(Task t){
        Task result = null;
        tasks.add(t);
        result = t;
        return result;
    }/**
     * Obtiene una tarea por su nombre desde la lista de tareas.
     * @param name El nombre de la tarea a buscar
     * @return La tarea encontrada, o null si no se encontró ninguna tarea con el nombre especificado
     */
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
    /**
     * Obtiene una lista de tareas por su estado desde la lista de tareas.
     * @param status El estado de las tareas a buscar
     * @return La lista de tareas con el estado especificado
     */
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
    /**
     * Actualiza una tarea en la lista de tareas.
     * @param t La tarea con los datos actualizados
     * @return La tarea actualizada, o null si la tarea no se encontró
     */
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
    /**
     * Elimina una tarea de la lista de tareas.
     * @param t La tarea a eliminar
     * @return La tarea eliminada, o null si la tarea no se encontró
     */
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
    /**
     * Crea una nueva tarea y la agrega a la lista de tareas.
     * @return true si la tarea se agregó con éxito, false si no se agregó
     */
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
