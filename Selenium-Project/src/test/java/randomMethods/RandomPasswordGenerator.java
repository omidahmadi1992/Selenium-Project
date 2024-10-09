package randomMethods;

import java.util.Random;

public class RandomPasswordGenerator {

    public static void main(String[] args) {
        // Print a randomly generated password when the program starts
        System.out.println(generateRandomPassword());
    }

    // Method to generate a random password meeting specific criteria
    private static String generateRandomPassword() {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*-_.";
        //String specialChars = "!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";

        Random random = new Random();
        StringBuilder sb = new StringBuilder(8); // Length of the generated password

        // Ensure the password contains at least one uppercase letter, one lowercase letter, one digit, and one special character
        sb.append(upperCaseLetters.charAt(random.nextInt(upperCaseLetters.length())));
        sb.append(lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length())));
        sb.append(numbers.charAt(random.nextInt(numbers.length())));
        sb.append(specialChars.charAt(random.nextInt(specialChars.length())));

        // Fill the rest of the password with random characters
        for (int i = 4; i < 8; i++) {
            String randomChars = upperCaseLetters + lowerCaseLetters + numbers + specialChars;
            sb.append(randomChars.charAt(random.nextInt(randomChars.length())));
        }

        // Shuffle the generated password to ensure randomness
        String password = sb.toString();
        char[] passwordArray = password.toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int randomIndex = random.nextInt(passwordArray.length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[randomIndex];
            passwordArray[randomIndex] = temp;
        }
        return new String(passwordArray);
    }

}
