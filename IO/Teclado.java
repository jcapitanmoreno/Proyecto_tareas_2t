package IO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Teclado {
    private static Scanner scanner = new Scanner(System.in);

    public String leerString() {
        return scanner.nextLine();
    }

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

    public static String readString(String msg) {
        System.out.println(msg);
        String line;
        while (((line = scanner.nextLine()).trim().equals(""))) ;
        return line;
    }

    public static void printMsg(String msg) {
        System.out.println(msg);
    }

    public static void pressEnter() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Press enter to continue.");
        teclado.nextLine();
    }

    public static LocalDate readDate(String msg) {
        System.out.println(msg);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        return LocalDate.parse(scanner.nextLine(), formatter);
    }

}
