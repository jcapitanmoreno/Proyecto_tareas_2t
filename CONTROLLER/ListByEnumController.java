package CONTROLLER;

import MODEL.Project;
import MODEL.RepoProject;
import MODEL.Task;
import MODEL.TaskStatus;
import VIEW.ListTaskByStatus;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class ListByEnumController {
    ListTaskByStatus listTaskByStatus = new ListTaskByStatus();
    private RepoProject repoProject;

    public ListByEnumController() {
        this.repoProject = RepoProject.get_Instance();
    }

    public void listTaskStatus() throws NoSuchAlgorithmException {
        int option = -1;
        do {
            option = listTaskByStatus.byStatus();
            ListByEnumSwitch(option);
        } while (option != 4);

    }

    public void ListByEnumSwitch(int opcion) {
        List<Project> projects = (List<Project>) repoProject.getAll(); // No es necesario un casting aquí
        switch (opcion) {
            case 1:
                listTasksSinIniciar(projects);
                break;
            case 2:
                listTasksEnTramite(projects);
                break;
            case 3:
                listTasksFinalizadas(projects);
                break;
            case 4:
                System.out.println("saliendo ...");
            default:
                System.out.println(("Opción no válida. Elige otra opción"));
        }
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