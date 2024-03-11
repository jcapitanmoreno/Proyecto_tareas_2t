package CONTROLLER;

import MODEL.*;
import VIEW.ListTaskByStatus;

import java.util.ArrayList;
import java.util.List;

public class ListTaskController {
    private RepoProject repoProject;
    ListTaskByStatus listTaskByStatus = new ListTaskByStatus();

    public ListTaskController() {
        this.repoProject = RepoProject.get_Instance();
    }

    public void listTask() {
        if (repoProject==null) {
            System.out.println("El repositorio de proyectos no está inicializado.");
            return;
        }

        List<Task> tasks = repoProject.getTasks();// Convierte el conjunto a lista
        if (tasks.isEmpty()) {
            System.out.println("No hay tareas guardadas.");
        } else {
            System.out.println("Tareas guardadas:");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}