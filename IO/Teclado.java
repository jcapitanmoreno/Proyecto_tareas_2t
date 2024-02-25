package IO;

import java.util.Scanner;

public class Teclado {
    private static Scanner scanner = new Scanner(System.in);

    public static String leerString() {
        return scanner.nextLine();
    }

    public static int leerEntero() {
        while (!scanner.hasNextInt()) {
            System.out.println("Por favor, ingrese un valor valido: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}
