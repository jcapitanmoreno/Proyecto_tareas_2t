package VIEW;

import CONTROLLER.UpdateStateController;
import IO.Teclado;
import MODEL.Project;
import MODEL.TaskStatus;

import java.awt.*;

public class UpdateStateTaskView{
    UpdateStateController updateStateController = new UpdateStateController();
    Teclado teclado = new Teclado();

    public void displayTaskStatusOptions(int option) {
        switch (option){
            case 1:

                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Opción no valida.");
                break;
        }
    }
}
