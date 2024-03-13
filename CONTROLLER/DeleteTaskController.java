package CONTROLLER;

import IO.Teclado;
import MODEL.Project;
import MODEL.RepoProject;
import VIEW.DeleteTaskView;

public class DeleteTaskController {
    private RepoProject repoProject = RepoProject.get_Instance();
    private DeleteTaskView deleteTaskView = new DeleteTaskView();
    /**
     * Elimina una tarea de un proyecto especificado.
     * Solicita al usuario el nombre de la tarea que desea eliminar mediante la vista deleteTaskView.
     * Busca el proyecto por nombre en el repositorio de proyectos.
     * Si la tarea no es "volver" y el proyecto existe, elimina la tarea del proyecto en el repositorio.
     * Muestra mensajes de confirmación o error según el resultado de la eliminación.
     * Guarda los cambios en el repositorio de proyectos y devuelve el proyecto modificado o null si no se encontró el proyecto.
     * @param project El proyecto del que se eliminará la tarea.
     * @return El proyecto modificado con la tarea eliminada, o null si no se encontró el proyecto.
     */
    public Project deleteTask(Project project) {
        String taskNameToDelete = deleteTaskView.taskToDelete();
        Project projectToDeleteFrom = null;
        if (!taskNameToDelete.equalsIgnoreCase("volver")) {
            projectToDeleteFrom = repoProject.getByName(project.getName());
            if (projectToDeleteFrom != null) {
                boolean deleted = repoProject.deleteTask(taskNameToDelete);
                if (deleted) {
                    deleteTaskView.printMsg1();
                } else {
                    deleteTaskView.printMsg2();
                }
            }
        }
        repoProject.save();
        return projectToDeleteFrom;
    }
}
