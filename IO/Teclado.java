package IO;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teclado implements Serializable {
    private static Scanner scanner = new Scanner(System.in);

    public String leerString() {
        return scanner.nextLine();
    }

    /**
     * Método para leer un número entero desde la entrada estándar.
     *
     * @param msg El mensaje a mostrar al usuario.
     * @return El número entero leído.
     */
    public static int leerEntero(String msg) {
        System.out.println(msg);
        int numero = 0;
        boolean entradaValida = false;
        while (!entradaValida) {
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                entradaValida = true;
            } else {
                System.out.println("Entrada inválida. Por favor, ingresa un entero.");
                scanner.next(); // Consume la entrada no válida
            }
        }
        return numero;
    }

    /**
     * Método para leer una cadena de texto desde la entrada estándar.
     *
     * @param msg El mensaje a mostrar al usuario.
     * @return La cadena de texto leída.
     */
    public static String readString(String msg) {
        System.out.println(msg);
        String line;
        while (((line = scanner.nextLine()).trim().equals(""))) ;
        return line;
    }

    /**
     * Método para imprimir un mensaje en la consola.
     *
     * @param msg El mensaje a imprimir.
     */
    public void printMsg(String msg) {
        System.out.println(msg);
    }

    /**
     * Método para esperar a que el usuario presione Enter.
     */
    public static void pressEnter() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Pulsa intro para continuar.");
        teclado.nextLine();
    }

    /**
     * Método para leer una fecha desde la entrada estándar.
     *
     * @param msg El mensaje a mostrar al usuario.
     * @return La fecha leída.
     */
    public static LocalDate readDate(String msg) {
        System.out.println(msg);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        //Valida el string con expresiones regulares para asegurate que tenga formato xd xm yyyy
        boolean valida = false;
        String primerosDigitos = "";
        String segundosDigitos = "";
        String tercerosDigitos = "";
        do {
            String loqueinserta = scanner.nextLine();
            String regex = "\\b(\\d{1,2})\\s(\\d{1,2})\\s(\\d{4})\\b";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(loqueinserta);
            valida = matcher.matches();
            if (!valida) {
                System.out.println("El formato es incorrecto, porfavor escriba la fecha de nuevo");
            } else {
                primerosDigitos = matcher.group(1);
                segundosDigitos = matcher.group(2);
                tercerosDigitos = matcher.group(3);
            }
        } while (!valida);
        primerosDigitos = primerosDigitos.length() == 2 ? primerosDigitos : "0" + primerosDigitos;
        segundosDigitos = segundosDigitos.length() == 2 ? segundosDigitos : "0" + segundosDigitos;


        return LocalDate.parse(primerosDigitos + " " + segundosDigitos + " " + tercerosDigitos, formatter);
    }

    /**
     * Método para leer una fecha desde la entrada estándar, asegurando que sea anterior a la fecha actual.
     *
     * @param msg El mensaje a mostrar al usuario.
     * @return La fecha leída.
     */
    public static LocalDate readDateBeforeToday(String msg) {
        LocalDate fecha = null;
        boolean valida = false;
        do {
            fecha = readDate(msg);
            valida = LocalDate.now().isBefore(fecha);
            if (!valida) {
                System.out.println("La fecha no puede ser anterior a hoy");
            }
        } while (!valida);
        return fecha;
    }

    /**
     * Método para leer un número desde la entrada estándar, dentro de un rango especificado.
     *
     * @param msg      El mensaje a mostrar al usuario.
     * @param numMenor El límite inferior del rango.
     * @param numMayor El límite superior del rango.
     * @return El número leído.
     */
    public static int readNumber(String msg, int numMenor, int numMayor) {
        int numero = 0;
        do {
            System.out.print(msg);
            try {
                numero = scanner.nextInt();

            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Por favor, introduce un número valido.");

            }

            if (numero < numMenor || numero > numMayor) {
                System.out.println("La opción introducida no se contempla. Pruebe de nuevo.");

            }

        } while (numero < numMenor || numero > numMayor);
        return numero;
    }
}
