package beaconFire.d2.guess;

import java.util.Scanner;

public class GuessingGameTester {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GuessingGame game = new GuessingGame();

        System.out.println("Welcome to the Number Guessing Game");

        boolean playAgain = true;

        while (playAgain) {

            System.out.print("Enter the maximum number");
            int max = scanner.nextInt();
            game.setMax(max);


            System.out.print("Enter how number of guess allowed ");
            int maxGuesses = scanner.nextInt();

            game.newGame(maxGuesses);

            System.out.println("ans "+game.getAnswer());

            System.out.println("A new game has started! Guess a number between 0 and " + max);

            while (!game.isGameOver()) {

                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();

                String result = game.guess(userGuess);
                System.out.println(result);

                if (result.contains("Correct")) {
                    System.out.println("You guessed the correct number!");
                    game.setGameOver(true);
                }

                if (game.getMaxGuessesTaken() >= game.getMaxGuessesAllowed()) {
                    System.out.println("No guesses left. The correct answer was: " + game.getAnswer());
                    game.setGameOver(true);
                }
            }

            System.out.print("Play again? (y/n): ");
            String choice = scanner.next();
            playAgain = choice.equalsIgnoreCase("y");
        }

        System.out.println("Thanks for playing!");
    }
}
