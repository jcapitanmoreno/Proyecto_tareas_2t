package Test;

import IO.Teclado;

import java.time.LocalDate;

public class TestDate {
    public static void main(String[] args) {
        LocalDate fecha = Teclado.readDateBeforeToday("Dame fecha");
        System.out.println(fecha);
    }
}
