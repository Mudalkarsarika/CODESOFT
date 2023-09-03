
import java.util.*;

public class NumberGuessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        int maxAttempts = 5;
        int roundsPlayed = 0;
        int roundsWon = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            int targetNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean isGuessCorrect = false;

            System.out.println("Round " + (++roundsPlayed));

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed it correct " + targetNumber +
                            " in " + attempts + " attempts.");
                    isGuessCorrect = true;
                    roundsWon++;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            if (!isGuessCorrect) {
                System.out.println("Sorry, you've reached the maximum attempts. " +
                        "The correct number was " + targetNumber + ".");
            }

            System.out.print("Do you want to play again? (y/n): ");
            String playAgainInput = scanner.next().toLowerCase();
            playAgain = playAgainInput.equals("y");
        }

        System.out.println("Thanks for playing! You played " + roundsPlayed + " rounds and won " + roundsWon + " rounds.");
     
    }
}
