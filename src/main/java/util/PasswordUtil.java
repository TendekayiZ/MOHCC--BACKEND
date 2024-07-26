package util;

import java.security.SecureRandom;

import java.security.SecureRandom;

public class PasswordUtil {
    private static final String CHARACTERS = "ABCDEFGH1JKLMNOPRSTUVWXYZ0123456789abcdefghij";
    private static final int PASSWORD_LENGTH = 10;
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String encryptPassword(String password) {
        // Implement the password encryption logic here
        return password; // Placeholder, replace with actual encryption implementation
    }

    public static String generateRandomPassword() {
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            password.append(CHARACTERS.charAt(RANDOM.nextInt(CHARACTERS.length())));
        }
        return password.toString();
    }
}