package INTERFACES;

import MODEL.Project;

public interface ICreateProyectView {
    Project createProyect();
    void errorProjectName();
    void errorSameProyectName();

    public int chooseoption();
}
