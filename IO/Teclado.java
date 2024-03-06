package IO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Teclado {
    private static Scanner scanner = new Scanner(System.in);

    public  String leerString() {
        return scanner.nextLine();
    }

    public static int leerEntero(String msg) {
        System.out.println(msg);
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un valor valido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
    public static String readString(String msg) {
        System.out.println(msg);
        return scanner.nextLine();
    }

    public void printMsg(String msg) {
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
