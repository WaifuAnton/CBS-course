package helper;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public abstract class MeshPassword {
    public static String mesh(String password) {
        byte[] array = new byte[32];
        new Random().nextBytes(array);
        String salt = new String(array);
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-512");
        }
        catch (NoSuchAlgorithmException e) {
            System.out.println("No such algorithm");
        }
        messageDigest.reset();
        String beforeHash = password + salt;
        byte[] hash = messageDigest.digest(beforeHash.getBytes());
        return new String(hash);
    }
}
