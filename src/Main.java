import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        while (playAgain) {
            int dice1 = rollDice(random);
            int dice2 = rollDice(random);
            int sum = dice1 + dice2;

            System.out.println("Rolling the dice...");
            System.out.println("You rolled: " + dice1 + " + " + dice2 + " = " + sum);

            if (sum == 2 || sum == 3 || sum == 12) {
                System.out.println("Craps! You lose!");
            } else if (sum == 7 || sum == 11) {
                System.out.println("Natural! You win!");
            } else {
                System.out.println("The point is: " + sum);
                int point = sum;
                boolean continueRolling = true;

                while (continueRolling) {
                    System.out.print("Press Enter to roll the dice again...");
                    scanner.nextLine();

                    dice1 = rollDice(random);
                    dice2 = rollDice(random);
                    sum = dice1 + dice2;

                    System.out.println("Rolling the dice...");
                    System.out.println("You rolled: " + dice1 + " + " + dice2 + " = " + sum);

                    if (sum == 7) {
                        System.out.println("You rolled a 7. You lose!");
                        continueRolling = false;
                    } else if (sum == point) {
                        System.out.println("You made the point (" + point + ")! You win!");
                        continueRolling = false;
                    } else {
                        System.out.println("You didn't make the point (" +point+ ").");
                    }
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainResponse = scanner.nextLine();
            playAgain = playAgainResponse.equalsIgnoreCase("yes");
        }
    }

    private static int rollDice(Random random) {
        return random.nextInt(6) + 1; // Returns a random number between 1 and 6
    }
}
