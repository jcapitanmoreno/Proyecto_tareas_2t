package VIEW;

import INTERFACES.IListTaskView;
import MODEL.Task;

import java.util.List;

public class ListTaskView implements IListTaskView {

    @Override
    public void listTask(List<Task> tasks) {
        System.out.println("**********************");
        for (Task task : tasks) {
            System.out.println(task);
        }
        System.out.println("**********************");
    }
    public void printMsg1(){
        System.out.println("saliendo ...");
    }
    public void printMsg2(){
        System.out.println("Opción no válida. Elige otra opción");
    }
}
