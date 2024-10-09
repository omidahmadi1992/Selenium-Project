package randomMethods;

import java.time.LocalDate;
import java.util.Random;

public class RandomDateOfBirth {
    public static void main(String[] args) {
        // Generate a random date of birth within a reasonable age range (e.g., 18-30 years old)
        LocalDate randomDOB = generateRandomDOB(18, 30);

        // Print the randomly generated date of birth
        System.out.println("Random Date of Birth: " + randomDOB);
    }

    /**
     * Method to generate a random date of birth within a specified age range.
     * @param minAge Minimum age (in years)
     * @param maxAge Maximum age (in years)
     * @return LocalDate object representing the random date of birth
     */
    private static LocalDate generateRandomDOB(int minAge, int maxAge) {
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        // Calculate the minimum and maximum dates of birds based on given ages
        LocalDate minDOB = currentDate.minusYears(maxAge);
        LocalDate maxDOB = currentDate.minusYears(minAge);

        // Generate a random birth date between minDOB and maxDOB
        Random random = new Random();
        long minDay = minDOB.toEpochDay();
        long maxDay = maxDOB.toEpochDay();
        long randomDay = minDay + random.nextInt((int) (maxDay - minDay));

        // Convert randomDay back to LocalDate and return
        return LocalDate.ofEpochDay(randomDay);
    }
}
