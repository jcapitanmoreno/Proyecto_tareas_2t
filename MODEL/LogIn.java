package MODEL;

import IO.Teclado;

import java.util.regex.Pattern;
import java.io.IOException;
import java.io.*;

public class LogIn {
    Teclado teclado = new Teclado();
    String userText;
    User user = new User("","","","");

    public static boolean isMailValid(String mail) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(mail).matches();
    }

    public void creatUserTXT(){
        try {
            FileOutputStream fileOut = new FileOutputStream("usersParameters.txt");
            do {
                System.out.println("Introduce el texto a guardar (hasta que escribas 'exit'):");
                userText = teclado.leerString();
                fileOut.write(userText.getBytes());
                fileOut.write("\n".getBytes());
            } while (!userText.equals("exit"));
            fileOut.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void registerUser(String name, String user, String mail, String password){
        do {
            creatUserTXT();
            userText = teclado.leerString();
        }while ();


    }

    public void inicioSesion(String user, String password) {

        teclado.leerString();
        do {
            teclado.printMsg("contraseña o usuario erroneos, prueba otra vez");
        } while (!user.equals(user) || !user.equals(password));

        teclado.printMsg("iniciado correctamente. Continue con su trabajo");

    }

}
