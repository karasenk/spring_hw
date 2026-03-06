package hw.util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class HashUtil {
    public static String hashPassword(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }
    public static boolean verifyPassword(String plainPassword, String hashedPassword){
        return BCrypt.verifyer().verify(plainPassword.toCharArray(), hashedPassword).verified;
    }
}
