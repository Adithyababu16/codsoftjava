import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int totalRounds = 0;
        int roundsWon = 0;
        
        while (true) {
            // Step 1: Generate a random number within a specified range
            int targetNumber = random.nextInt(100) + 1;
            
            // Step 5: Limit the number of attempts
            int attempts = 0;
            int maxAttempts = 10; // You can adjust this as needed
            
            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I'm thinking of a number between 1 and 100. You have " + maxAttempts + " attempts to guess it.");
            
            boolean hasGuessedCorrectly = false;
            
            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                
                // Step 2: Prompt the user to enter their guess
                int guess;
                try {
                    guess = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid integer.");
                    continue;
                }
                
                // Step 3: Compare the user's guess with the generated number
                if (guess < targetNumber) {
                    System.out.println("Too low!");
                } else if (guess > targetNumber) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You've guessed the number!");
                    hasGuessedCorrectly = true;
                    break;
                }
                
                attempts++;
                System.out.println("You have " + (maxAttempts - attempts) + " attempts left.");
            }
            
            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
            } else {
                roundsWon++;
            }
            
            totalRounds++;
            
            // Step 6: Add the option for multiple rounds
            System.out.print("Would you like to play again? (yes/no): ");
            String playAgain = scanner.nextLine().trim().toLowerCase();
            
            if (!playAgain.equals("yes")) {
                break;
            }
        }
        
        // Step 7: Display the user's score
        System.out.println("Total Rounds Played: " + totalRounds);
        System.out.println("Rounds Won: " + roundsWon);
        
        scanner.close();
    }
}
