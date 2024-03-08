package INTERFACES;

import MODEL.Project;
import MODEL.Session;

public interface ICreateProyectView {
    int createInformation();
    Project createProyect();
    void errorProjectName();
    void errorSameProyectName();
}
