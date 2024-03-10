package VIEW;

import INTERFACES.IListTaskView;
import MODEL.Task;

import java.util.List;

public class ListTaskView implements IListTaskView {

    @Override
    public void listTask(List<Task> tasks) {
        System.out.println("**********************");
        for (Task task : tasks) {
            System.out.println(tasks);
        }
        System.out.println("**********************");
    }
}
