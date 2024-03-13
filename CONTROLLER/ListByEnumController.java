package CONTROLLER;

import IO.Teclado;
import MODEL.Project;
import MODEL.RepoProject;
import MODEL.Task;
import MODEL.TaskStatus;
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
    /**
     * Lista las tareas por estado.
     * Ejecuta un bucle que solicita al usuario que elija una opción de estado de tarea.
     * Llama al método byStatus() de la vista listTaskByStatus para obtener la opción seleccionada.
     * Llama al método ListByEnumSwitch() para manejar la opción seleccionada.
     * El bucle se ejecuta hasta que el usuario elija salir (opción 4).
     * @throws NoSuchAlgorithmException si ocurre un error relacionado con el algoritmo de hash (en caso de que se use).
     */
    public void listTaskStatus() throws NoSuchAlgorithmException {
        int option = -1;
        do {
            option = listTaskByStatus.byStatus();
            ListByEnumSwitch(option);
        } while (option != 4);

    }
    /**
     * Lista las tareas según la opción seleccionada por el usuario.
     * Obtiene todos los proyectos del repositorio de proyectos.
     * Utiliza una estructura de selección switch para determinar qué método de listado de tareas llamar
     * basado en la opción seleccionada por el usuario.
     * @param opcion La opción seleccionada por el usuario para listar las tareas.
     */
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

                listTaskView.printMsg1();
            default:
                listTaskView.printMsg2();
        }
    }
    /**
     * Lista las tareas de todos los proyectos según el estado especificado.
     * Itera sobre la lista de proyectos y obtiene las tareas con el estado especificado para cada proyecto.
     * Imprime las tareas encontradas en el estado especificado para cada proyecto.
     * @param status El estado de las tareas que se desean listar.
     * @param projects La lista de proyectos de la cual se listarán las tareas.
     */
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

    /**
     * Lista las tareas de todos los proyectos que se encuentran en el estado 'Sin Iniciar'.
     * Llama al método listTasksByStatus() con el estado 'Sin Iniciar'.
     * @param projects La lista de proyectos de la cual se listarán las tareas.
     */
    public void listTasksSinIniciar(List<Project> projects) {
        listTasksByStatus(TaskStatus.SIN_INICIAR, projects);
    }

    /**
     * Lista las tareas de todos los proyectos que se encuentran en el estado 'En Trámite'.
     * Llama al método listTasksByStatus() con el estado 'En Trámite'.
     * @param projects La lista de proyectos de la cual se listarán las tareas.
     */
    public void listTasksEnTramite(List<Project> projects) {
        listTasksByStatus(TaskStatus.EN_TRAMITE, projects);
    }

    /**
     * Lista las tareas de todos los proyectos que se encuentran en el estado 'Finalizada'.
     * Llama al método listTasksByStatus() con el estado 'Finalizada'.
     * @param projects La lista de proyectos de la cual se listarán las tareas.
     */
    public void listTasksFinalizadas(List<Project> projects) {
        listTasksByStatus(TaskStatus.FINALIZADA, projects);
    }


}