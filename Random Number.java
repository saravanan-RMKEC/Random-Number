import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int min = 1;
        int max = 100;
        boolean playAgain = true;
        int score = 0;

        while (playAgain) {
            int randomNumber = random.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean correctGuess = false;
            System.out.println("I have generated a number between " + min + " and " + max + ". Try to guess it!");

            while (!correctGuess && attempts < 10) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == randomNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    correctGuess = true;
                    score += 10 - attempts;
                } else if (userGuess < randomNumber) {
                    System.out.println("Your guess is too low. Try again.");
                } else {
                    System.out.println("Your guess is too high. Try again.");
                }
            }

            if (!correctGuess) {
                System.out.println("Sorry, you've used all attempts. The correct number was " + randomNumber + ".");
            }

            System.out.println("Your score: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is " + score + ".");
        scanner.close();
    }
}
