package Test;

import IO.Security;
import IO.Teclado;

import java.security.NoSuchAlgorithmException;

public class HashTest {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(Security.hashPassword("HolaMundo"));
        System.out.println(Security.hashPassword("HolaMundo123"));
    }
}
