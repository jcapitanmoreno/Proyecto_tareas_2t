package CONTROLLER;


import INTERFACES.ISesionController;
import IO.Teclado;
import VIEW.CreateUserView;
import VIEW.LogInView;
import VIEW.SesionView;
import VIEW.WelcomeByeView;

public class SesionController implements ISesionController {
    SesionView sesionView=new SesionView();
    LogInView login = new LogInView();
    CreateUserView createUserView = new CreateUserView();
    WelcomeByeView welcomeByeView= new WelcomeByeView();
    @Override
    public void chooseoption() {
        int opcion = -1;
        do {
            opcion = sesionView.chooseoption();
            manejarOpcionMenu(opcion);
        }while(opcion!=3);
    }


    // Método para manejar la opción seleccionada del menú
    public void manejarOpcionMenu(int opcion) {
        switch (opcion) {
            case 1:
             login.chooseLogIn();
                break;
            case 2:
            createUserView.createUser();
                Teclado.pressEnter();
                break;
            case 3:
             welcomeByeView.byeProgram();
                break;
            default:

        }
    }
}
