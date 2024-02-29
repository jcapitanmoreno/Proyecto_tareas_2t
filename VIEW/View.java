package VIEW;

import CONTROLLER.Controller;
import CONTROLLER.CreateUser;
import INTERFACES.Iview;
import IO.Teclado;

import static CONTROLLER.Controller.Createuser;

public class View implements Iview {

    public void IniciarSesion() {
        System.out.println("*********************************");
        System.out.println("* \n Pulse 1 para iniciar sesion *");
        int opcion = Teclado.leerEntero();
        System.out.println("*********************************");
        Controller.UserInformation(opcion);
    }

    public void CrearUsuario() {
        System.out.println("*********************************");
        System.out.println("* \n Pulse 2 para crear Usuario  *");
        System.out.println("*********************************");
        if(Teclado.leerEntero() == 2) {
            Createuser();
        }

    public void EliminarUsuario() {
        System.out.println("*********************************");
        System.out.println("* \n Pulse 3 para eliminar un Usuario  *");
        System.out.println("*********************************");
    }

    public void Tarea() {
        System.out.println("*********************************");
        System.out.println("*                               *");
        System.out.println("*                               *");
        System.out.println("*********************************");
    }
}
