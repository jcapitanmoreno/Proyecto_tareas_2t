package INTERFACES;

import IO.Teclado;
import MODEL.Project;
import MODEL.Session;

public interface ICreateProyectView {
    Project createProyect();
    void errorProjectName();
    void errorSameProyectName();
    int chooseoption();
}
