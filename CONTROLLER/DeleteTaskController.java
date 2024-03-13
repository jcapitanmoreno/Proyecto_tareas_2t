package CONTROLLER;

import IO.Teclado;
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
