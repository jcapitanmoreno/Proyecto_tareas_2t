package CONTROLLER;

import IO.Teclado;
import MODEL.*;
import VIEW.ListTaskByStatus;

import java.util.ArrayList;
import java.util.List;

public class ListTaskController {
    private RepoProject repoProject;
    ListTaskByStatus listTaskByStatus = new ListTaskByStatus();
    Teclado teclado = new Teclado();

    public ListTaskController() {
        this.repoProject = RepoProject.get_Instance();
    }

    public void listTask() {
        if (repoProject==null) {
            teclado.printMsg("El repositorio de proyectos no está inicializado.");
            return;
        }

        List<Task> tasks = repoProject.getTasks();// Convierte el conjunto a lista
        if (tasks.isEmpty()) {
            teclado.printMsg("No hay tareas guardadas.");
        } else {
            teclado.printMsg("Tareas guardadas:");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
}