package randomMethods;

import java.util.Random;

public class RandomNameGenerator {
    public static void main(String[] args) {
        // Arrays of example first names and last names
        String[] firstNames = {"Alice", "Bob", "Charlie", "David", "Emma", "Frank", "Grace", "Henry", "Ivy", "Jack"};
        String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor"};

        // Generate a random name
        String randomName = generateRandomName(firstNames, lastNames);

        // Print the randomly generated name
        System.out.println("Random Name: " + randomName);

    }

    /**
     * Method to generate a random full name.
     * @param firstNames Array of first names
     * @param lastNames Array of last names
     * @return String representing a random full name
     */
    private static String generateRandomName(String[] firstNames, String[] lastNames) {
        Random random = new Random();

        // Generate random indices for first name and last name arrays
        int firstNameIndex = random.nextInt(firstNames.length);
        int lastNameIndex = random.nextInt(lastNames.length);

        // Concatenate random first name and last name to form a full name
        String randomFirstName = firstNames[firstNameIndex];
        String randomLastName = lastNames[lastNameIndex];
        String randomFullName = randomFirstName + " " + randomLastName;

        return randomFullName;
    }
}
