/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encriptacion;

/**
 *
 * @author lucascastro
 */
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
public class PasswordUtils {
    
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
    
     public static String getSalt(int length) {
        StringBuilder retorno = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            retorno.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }

        return new String(retorno);
    }

    public static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }

    public static String generarPasswordSeguro(String password, String salt) {
        String passwordGenerado = null;

        byte[] passwordSegura = hash(password.toCharArray(), salt.getBytes());
 
        passwordGenerado = Base64.getEncoder().encodeToString(passwordSegura);
 
        return passwordGenerado;
    }
    
    public static boolean verificarPassswordUsuario(String passwordProvisto,
            String passwordDeUsuario, String salt)
    {
        boolean iguales = false;
        
        // Generamos una contraseña con el mismo salt con la provista
        String nuevoPasswordGenerado = generarPasswordSeguro(passwordProvisto, salt);
        
        //Verificamos si son iguales
        iguales = nuevoPasswordGenerado.equalsIgnoreCase(passwordDeUsuario);
        
        return iguales;
    }
    
}
