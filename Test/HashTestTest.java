package Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class HashTestTest {
    static HashTest hashTest;

    static {
        try {
            hashTest = new HashTest();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String originalString = hashTest.originalString;
        MessageDigest digest = hashTest.digest;
        byte[] encodedhash = hashTest.encodedhash;

        System.out.println(originalString);
        System.out.println(digest);
        System.out.println(Arrays.toString(encodedhash));
    }
}
