package randomMethods;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class RandomPhoneNumber {
    public static void main(String[] args) {
        // Generate a random phone number and store it in a variable
        String phoneNumber = generateRandomPhoneNumber();
        // Print the generated phone number
        System.out.println("Generated phone number: " + phoneNumber);
    }
    // Method to generate a random phone number
    private static String generateRandomPhoneNumber() {
        // Create a new Random object to generate random numbers
        Random random = new Random();

        // Initialize an AtomicReference to hold a StringBuffer
       // AtomicReference<StringBuffer> sb = new AtomicReference<>(new StringBuffer());

        // StringBuilder to build the phone number string
        StringBuilder sb = new StringBuilder();
        // Loop 10 times to generate a 10-digit phone number
        for (int i = 0; i < 10; i++) {
            // Generate a random digit between 0 and 9
            int digit = random.nextInt(10);
            // Append (adding) the randomly generated digit to the StringBuilder
            sb.append(digit);
        }
        // Convert StringBuilder to String and return the generated phone number
        return sb.toString();
    }
}
