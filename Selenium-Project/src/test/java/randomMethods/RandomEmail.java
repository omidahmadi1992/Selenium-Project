package randomMethods;

public class RandomEmail {
    public static void main(String[] args) {

        // Define a prefix for the email address
        String emailPrefix = "Jawid";
        // Generate a random number between 0 and 99
        int number = (int) (Math.random() * 100);
        // Concatenate the prefix, random number, and the domain to form a random email address
        String randomEmail = emailPrefix + number + "@gmail.com";
        // Print the generated random email address
        System.out.println(randomEmail);
    }
}
