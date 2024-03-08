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
        int line = scanner.nextInt();
        return line;
    }

    public static String readString(String msg) {
        System.out.println(msg);
        String line;
        while(((line=scanner.nextLine()).trim().equals("")));
        return line;
    }

    public void printMsg(String msg) {
        System.out.println(msg);
    }

    public static void pressEnter() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Pulsa intro para continuar.");
        teclado.nextLine();
    }

    public static LocalDate readDate(String msg) {
        System.out.println(msg);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        return LocalDate.parse(scanner.nextLine(), formatter);
    }

}
