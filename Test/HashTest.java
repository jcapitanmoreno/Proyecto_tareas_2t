package Test;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashTest {
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    String originalString = "guerolaantonio";
    byte[] encodedhash = digest.digest(
            originalString.getBytes(StandardCharsets.UTF_8));

    public HashTest() throws NoSuchAlgorithmException {
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
