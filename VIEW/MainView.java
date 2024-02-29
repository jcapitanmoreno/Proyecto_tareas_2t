package VIEW;

import INTERFACES.IMainView;
import IO.Teclado;

public class MainView implements IMainView {

    @Override
    public int mainView() {
        System.out.println("*********************************");
        System.out.println("Pulse 1 para iniciar sesión.");
        System.out.println("Pulse 2 para listar los usuarios.");
        System.out.println("Pulse 3 para crear usuario.");
        System.out.println("Pulse 4 para eliminar un usuario.");
        System.out.println("Pulse 5 para ir a las tareas.");
        System.out.println("Pulse 6 para cerrar el programa.");
        return Teclado.leerEntero("*********************************");
    }

    /**@Override
    public void IniciarSesion(){
        System.out.println("*********************************");
        System.out.println("* \n Pulse 1 para iniciar sesión *");
        //int teclado= IO.Teclado.leerEntero();
        System.out.println("*********************************");
    }
    @Override
    public void CrearUsuario(){
        System.out.println("*********************************");
        System.out.println("* \n Pulse 2 para crear Usuario  *");
        System.out.println("*********************************");
    }
    @Override
    public void EliminarUsuario(){
        System.out.println("*********************************");
        System.out.println("* \n Pulse 3 para eliminar un Usuario  *");
        System.out.println("*********************************");
    }
    public void Tarea(){
        System.out.println("*********************************");
        System.out.println("*                               *");
        System.out.println("*                               *");
        System.out.println("*********************************");
    }**/
}
