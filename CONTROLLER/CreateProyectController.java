package CONTROLLER;

import INTERFACES.ICreateProyectView;
import MODEL.Project;

public class CreateProyectController {
    private final ICreateProyectView createProyectView;

    public CreateProyectController(ICreateProyectView createProyectView) {
        this.createProyectView = createProyectView;
    }

    public Project crearProyecto() {
        Project proyecto = createProyectView.createProyect();

        while (proyecto.getName().isEmpty()) {
            createProyectView.errorProjectName();
            proyecto = createProyectView.createProyect();
        }

        return proyecto;
    }
}