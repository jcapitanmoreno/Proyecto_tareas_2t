package IO;

import java.util.Scanner;

public class Teclado {
    private static Scanner scanner = new Scanner(System.in);

    public static String leerString() {
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

    //public String readString(String msg) {
    //    System.out.print(msg + ": ");
    //    return scanner.nextLine();
    //}

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

}
