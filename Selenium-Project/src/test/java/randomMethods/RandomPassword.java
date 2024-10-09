package randomMethods;

import java.util.Random;

public class RandomPassword {
    public static void main(String[] args) {
        String password = generateRandomPassword("Jawid$-");
        System.out.println("Generated password: " + password);
    }

    private static String generateRandomPassword(String prefix) {
        Random random = new Random();
        int number = random.nextInt(100); // Generate a random number between 0 and 99
        return prefix + number; // Concatenate prefix and random number to form the password
    }
}
