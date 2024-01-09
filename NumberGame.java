import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int maxRange = 100;
        int maxAttempts = 10 ;
        int rounds = 0;
        int score = 0;
        boolean playAgain = true;

        System.out.println("Welcome to the Random Number Guessing Game!");

        while (playAgain) {
            int randomNumber = random.nextInt(maxRange) + 1;
            int attempts = 0;
            boolean NumberhasGuessed = false;

            System.out.println("\nRound " + (rounds + 1) + ":");
            System.out.println("Guess the Random Number between 1 and " + maxRange + ". You have " + maxAttempts + " attempts.");

            while (!NumberhasGuessed && attempts < maxAttempts) {
                System.out.print("Enter your Guess Number: ");
                int Guess = scanner.nextInt();
                attempts++;

                if (Guess == randomNumber) {
                    NumberhasGuessed = true;
                    System.out.println("Congratulations! You Have Guessed the Number in " + attempts + " attempts.");
                    score += maxAttempts - attempts + 1;
                } else if (Guess < randomNumber) {
                    System.out.println("Try a Higher Number!");
                } else {
                    System.out.println("Try a Lower Number!");
                }
            }

            if (!NumberhasGuessed) {
                System.out.println("Sorry, You Have used all your attempts. The number was: " + randomNumber);
            }

            rounds++;
            System.out.print("\nDo you want to play again? (yes/no): ");
            String playChoice = scanner.next().toLowerCase();
            if (!playChoice.equals("yes")) {
                playAgain = false;
                System.out.println("Thanks for playing!");
            }
            
        }

        System.out.println("\nGame Over!");
        System.out.println("Rounds played: " + rounds);
        System.out.println("Total score: " + score);

        scanner.close();
    }
}
