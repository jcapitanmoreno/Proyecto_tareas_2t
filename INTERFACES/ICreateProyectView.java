package INTERFACES;

import MODEL.Project;

public interface ICreateProyectView {
    String createInformation();
    Project createProyect();
    void errorProjectName();
    void errorSameProyectName();
}
