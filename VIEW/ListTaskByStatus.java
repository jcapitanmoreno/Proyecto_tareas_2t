package VIEW;

import INTERFACES.IListTaskByStatus;
import MODEL.Project;
import MODEL.Task;
import MODEL.TaskStatus;

import java.util.List;

public class ListTaskByStatus implements IListTaskByStatus {
    @Override
    public int byStatus() {
        System.out.println("Elige el estado de la tarea para buscar: ");
        System.out.println("1. Sin iniciar.");
        System.out.println("2. En trámite.");
        System.out.println("3. Finalizada.");
        return IO.Teclado.leerEntero("4. Para salir");
    }

    public void listTasksByStatus(TaskStatus status, List<Project> projects) {
        for (Project project : projects) {
            List<Task> tasks = project.getTasksByStatus(status);
            if (!tasks.isEmpty()) {
                System.out.println("Tareas en estado " + status + " del proyecto " + project.getName() + ":");
                for (Task task : tasks) {
                    System.out.println(task);
                }
                System.out.println("--------");
            }
        }
    }

    public void listTasksSinIniciar(List<Project> projects) {
        listTasksByStatus(TaskStatus.SIN_INICIAR, projects);
    }

    public void listTasksEnTramite(List<Project> projects) {
        listTasksByStatus(TaskStatus.EN_TRAMITE, projects);
    }

    public void listTasksFinalizadas(List<Project> projects) {
        listTasksByStatus(TaskStatus.FINALIZADA, projects);
    }

    public void listTasksByStatus(TaskStatus status, List<Project> projects) {
        for (Project project : projects) {
            List<Task> tasks = project.getTasksByStatus(status);
            if (!tasks.isEmpty()) {
                System.out.println("Tareas en estado " + status + " del proyecto " + project.getName() + ":");
                for (Task task : tasks) {
                    System.out.println(task);
                }
                System.out.println("--------");
            }
        }
    }

    public void listTasksSinIniciar(List<Project> projects) {
        listTasksByStatus(TaskStatus.SIN_INICIAR, projects);
    }

    public void listTasksEnTramite(List<Project> projects) {
        listTasksByStatus(TaskStatus.EN_TRAMITE, projects);
    }

    public void listTasksFinalizadas(List<Project> projects) {
        listTasksByStatus(TaskStatus.FINALIZADA, projects);
    }
}
