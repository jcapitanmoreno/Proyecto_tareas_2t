package IO;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Security {
    /**
     * Convierte un arreglo de bytes en una cadena hexadecimal.
     * @param hash El arreglo de bytes que se convertirá.
     * @return La cadena hexadecimal correspondiente al arreglo de bytes.
     */
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
    /**
     * Calcula el hash SHA3-256 de una contraseña dada.
     * @param password La contraseña que se desea hashear.
     * @return El hash SHA3-256 de la contraseña.
     * @throws NoSuchAlgorithmException Si el algoritmo de hash no está disponible.
     */
    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        final MessageDigest digest = MessageDigest.getInstance("SHA3-256");
        final byte[] hashbytes = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));
        String sha3Hex = bytesToHex(hashbytes);
        return sha3Hex;
    }
}
