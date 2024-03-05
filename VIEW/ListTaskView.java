package VIEW;

import INTERFACES.ITaskView;
import MODEL.Project;
import MODEL.Task;

import java.util.List;

public class ListTaskView implements ITaskView {

    @Override
    public void listTask(List<Task> tasks) {
        System.out.println("**********************");
        for (Task task : tasks) {
            System.out.println(tasks);
        }
        System.out.println("**********************");
    }
}
