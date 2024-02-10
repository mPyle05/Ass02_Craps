import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object for user input
        Random random = new Random(); // Create a Random object for generating random numbers

        boolean playAgain = true; // Initialize a boolean variable to control the game loop

        // Main game loop
        while (playAgain) {
            int dice1 = rollDice(random); // Roll the first die
            int dice2 = rollDice(random); // Roll the second die
            int sum = dice1 + dice2; // Calculate the sum of the two dice

            // Display the result of the dice roll
            System.out.println("Rolling the dice...");
            System.out.println("You rolled: " + dice1 + " + " + dice2 + " = " + sum);

            // Check if the sum of the dice corresponds to winning or losing conditions
            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose!");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win!");
            } else {
                System.out.println("The point is: " + sum);
                int point = sum; // Store the point value for subsequent rolls
                boolean continueRolling = true; // Initialize a boolean variable to control subsequent rolls

                // Subsequent roll loop
                while (continueRolling) {
                    System.out.print("Press Enter to roll the dice again...");
                    scanner.nextLine(); // Wait for user to press Enter to continue rolling

                    dice1 = rollDice(random); // Roll the first die again
                    dice2 = rollDice(random); // Roll the second die again
                    sum = dice1 + dice2; // Calculate the sum of the two dice

                    // Display the result of the subsequent dice roll
                    System.out.println("Rolling the dice...");
                    System.out.println("You rolled: " + dice1 + " + " + dice2 + " = " + sum);

                    // Check if the sum equals 7, in which case the player loses
                    if (sum == 7) {
                        System.out.println("You rolled a 7. You lose!");
                        continueRolling = false; // End the subsequent roll loop
                    } else if (sum == point) { // Check if the sum equals the point, in which case the player wins
                        System.out.println("You made the point (" + point + ")! You win!");
                        continueRolling = false; // End the subsequent roll loop
                    } else { // Otherwise, the player continues rolling
                        System.out.println("You didn't make the point (" + point + ").");
                    }
                }
            }

            // Prompt the user to play again
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.nextLine();
            playAgain = playAgainResponse.equalsIgnoreCase("yes"); // Update the playAgain variable based on user input
        }
    }

    // Method to roll a single die and return the result
    private static int rollDice(Random random) {
        return random.nextInt(6) + 1; // Returns a random number between 1 and 6
    }
}
