package VIEW;

import INTERFACES.IWelcomeByeView;

public class WelcomeByeView implements IWelcomeByeView {
    @Override
    public void welcomeProgram() {
        System.out.println("*********************************");
        System.out.println("* Bienvenido al gestor de tareas *");
        System.out.println("*********************************");
    }

    @Override
    public void byeProgram() {
        System.out.println("*********************************");
        System.out.println("* Gracias por usar este programa *");
        System.out.println("*********************************");
    }
}
