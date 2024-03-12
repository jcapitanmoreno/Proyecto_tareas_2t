package CONTROLLER;

import MODEL.Project;
import MODEL.RepoProject;
import VIEW.DeleteTaskView;

public class DeleteTaskController {
    private RepoProject repoProject = RepoProject.get_Instance();
    private DeleteTaskView deleteTaskView = new DeleteTaskView();

    public Project deleteTask(Project project) {
        String taskNameToDelete = deleteTaskView.taskToDelete();
        Project projectToDeleteFrom = null;
        if (!taskNameToDelete.equalsIgnoreCase("volver")) {
            projectToDeleteFrom = repoProject.getByName(project.getName());
            if (projectToDeleteFrom != null) {
                boolean deleted = repoProject.deleteTask(taskNameToDelete);
                if (deleted) {
                    System.out.println("Tarea eliminada exitosamente.");
                } else {
                    System.out.println("No se pudo eliminar la tarea. La tarea no existe.");
                }
            }
        }
        repoProject.save();
        return projectToDeleteFrom;
    }
}
