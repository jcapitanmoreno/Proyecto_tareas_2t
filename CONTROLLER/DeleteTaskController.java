package CONTROLLER;

import IO.Teclado;
import MODEL.Project;
import MODEL.RepoProject;
import VIEW.DeleteTaskView;

public class DeleteTaskController {
    private RepoProject repoProject = RepoProject.get_Instance();
    private DeleteTaskView deleteTaskView = new DeleteTaskView();
    Teclado teclado = new Teclado();

    public Project deleteTask(Project project) {
        String taskNameToDelete = deleteTaskView.taskToDelete();
        Project projectToDeleteFrom = null;
        if (!taskNameToDelete.equalsIgnoreCase("volver")) {
            projectToDeleteFrom = repoProject.getByName(project.getName());
            if (projectToDeleteFrom != null) {
                boolean deleted = repoProject.deleteTask(taskNameToDelete);
                if (deleted) {
                    teclado.printMsg("Tarea eliminada exitosamente.");
                } else {
                    teclado.printMsg("No se pudo eliminar la tarea. La tarea no existe.");
                }
            }
        }
        repoProject.save();
        return projectToDeleteFrom;
    }
}
