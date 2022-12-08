import java.util.*;

public class HomeWork11Task1 {
    public static void main(String[] args) {
        Random random = new Random();
        int guessedNumber = random.nextInt(1, 100);
        int userNumber = 0;
        System.out.println("The computer chose a number between 1 and 100. Try to guess it:");

        while (userNumber != guessedNumber) {
            try {
                Scanner scanner = new Scanner(System.in);
                userNumber = scanner.nextInt();

                if (userNumber > 100 || userNumber < 1) {
                    System.out.println("The computer doesn't play like that. Your number is not between 1 and 100. Try again.");
                }

                if (userNumber < guessedNumber) {
                    System.out.println("Guessed number is more. Try again.");
                }

                if (userNumber > guessedNumber) {
                    System.out.println("Guessed number is less. Try again.");
                }

                if (userNumber == guessedNumber) {
                    scanner.close();
                    System.out.println("\nYou won! The secret number is " + guessedNumber + ".");
                }

            } catch (InputMismatchException e) {
                System.out.println("It doesn't look like a number to guess... Try again.");
            }
        }
    }
}