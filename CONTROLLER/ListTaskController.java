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
    public void listTask(Project p) {
        if (repoProject==null) {
            teclado.printMsg("El repositorio de proyectos no está inicializado.");
            return;
        }
        List<Task> tasks = repoProject.getTasks(p);// Convierte el conjunto a lista
        if (tasks.isEmpty()) {
            teclado.printMsg("No hay tareas guardadas.");
        } else {
            teclado.printMsg("Tareas guardadas:");
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }
    public void removeTask(Project p) {
        if (repoProject==null) {
            System.out.println("El repositorio de proyectos no está inicializado.");
            return;
        }

        List<Task> tasks = repoProject.getTasks(p);// Convierte el conjunto a lista
        if (tasks.isEmpty()) {
            System.out.println("No hay tareas que borrar.");
        } else {
            for (Task task : tasks) {
                tasks.remove(task);
            }
            System.out.println("Tarea borrada.");
        }
    }
}