package IO;

import java.util.Scanner;

public class Teclado {
    private static Scanner scanner = new Scanner(System.in);

    public  String leerString() {
        return scanner.nextLine();
    }

    public static int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un valor valido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public String readString(String msg) {
        System.out.print(msg + ": ");
        return scanner.nextLine();
    }

    public void printMsg(String msg) {
        System.out.println(msg);
    }

}
