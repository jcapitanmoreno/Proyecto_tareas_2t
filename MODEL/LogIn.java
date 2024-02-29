package MODEL;

import java.util.regex.Pattern;

public class LogIn {

    public static boolean isMailValid(String mail){
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(mail).matches();
    }

    public void inicioSesion(){

    }
}
