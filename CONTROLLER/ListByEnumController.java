package CONTROLLER;

import MODEL.Project;
import MODEL.RepoProject;
import VIEW.ListTaskByStatus;
import VIEW.ListTaskView;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public class ListByEnumController {
    ListTaskByStatus listTaskByStatus = new ListTaskByStatus();
    private RepoProject repoProject;
    ListTaskView listTaskView = new ListTaskView();

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
                listTaskByStatus.listTasksSinIniciar(projects);
                break;
            case 2:
                listTaskByStatus.listTasksEnTramite(projects);
                break;
            case 3:
                listTaskByStatus.listTasksFinalizadas(projects);
                break;
            case 4:
                listTaskView.printMsg1();
            default:
                listTaskView.printMsg2();
        }
    }
}