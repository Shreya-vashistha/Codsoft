
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int score = 0;
        int maxAttempts = 5;  // Limiting number of attempts

        System.out.println("Welcome to the Guessing Game!");

        while (playAgain) {
            int randomNumber = random.nextInt(100) + 1; // Generates a number between 1 and 100
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("I have generated a number between 1 and 100. Can you guess it? You have " + maxAttempts + " attempts.");

            // Guessing loop
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was: " + randomNumber);
            }

            System.out.println("Your current score: " + score);

            // Option to play again
            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Game over! Your final score: " + score);
        scanner.close();
    }
}
