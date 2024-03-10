package INTERFACES;

import MODEL.Project;
import MODEL.Session;

public interface ICreateProyectView {
    Project createProyect();
    void errorProjectName();
    void errorSameProyectName();

    public int chooseoption();
}
