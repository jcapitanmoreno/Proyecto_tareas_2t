package VIEW;

import INTERFACES.IWelcomeByeView;

public class WelcomeByeView implements IWelcomeByeView {
    /**
     * Muestra un mensaje de bienvenida al usuario al iniciar el programa.
     */
    @Override
    public void welcomeProgram() {
        System.out.println("**********************************");
        System.out.println("* Bienvenido al gestor de tareas *");
        System.out.println("**********************************");
    }

    /**
     * Muestra un mensaje de despedida al usuario al salir del programa.
     */
    @Override
    public void byeProgram() {
        System.out.println("**********************************");
        System.out.println("* Gracias por usar este programa *");
        System.out.println("**********************************");
    }
}