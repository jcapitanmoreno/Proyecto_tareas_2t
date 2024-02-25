package VIEW;

import INTERFACES.IloginView;

public class LoginView implements IloginView {

    @Override
    public void MenuDeInicio(){
        System.out.println("*************************");
        System.out.println("añade tu nombre: ");
        System.out.println("añade la contraseña: ");
        System.out.println("añade tu gmail: ");
        System.out.println("**************************");
    }
}
