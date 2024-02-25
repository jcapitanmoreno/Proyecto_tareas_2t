package VIEW;

import INTERFACES.Iview;
import IO.Teclado;

import java.util.Scanner;

public class View implements Iview {

    @Override
    public int IniciarSesion(){
        System.out.println("*********************************");
        System.out.println("* \n Pulse 1 para iniciar sesion *");
        int teclado= IO.Teclado.leerEntero();
        System.out.println("*********************************");
        return teclado;
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
    }
}
