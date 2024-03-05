package CONTROLLER;

import MODEL.Project;
import MODEL.Task;

import java.util.Iterator;
import java.util.List;

public class CreateTask {
    private List<Task> tasks;

    public boolean createTask(Task t) {
        boolean userAdded = false;
        if (!tasks.contains(t)) {
            tasks.add(t);
            userAdded = true;
        }
        return userAdded;

    }
    public Task removeUser(Task t){
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

}
