import java.util.InputMismatchException;
import java.util.Scanner;

public class HomeWork11Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int resultOfDivision = divide(setDividend(), setDivisor());
        scanner.close();
        System.out.println("\nResult of division = " + resultOfDivision);
    }

    private static int setDividend() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter dividend as Integer:");

        while (true) {

            try {
                int dividend = scanner.nextInt();
                return dividend;

            } catch (InputMismatchException ex) {
                System.out.println("Entered dividend is not an Integer. Try again.");
                scanner.next();
            }

        }
    }

    private static int setDivisor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter divisor as Integer:");

        while (true) {

            try {
                int divisor = scanner.nextInt();
                return divisor;

            } catch (InputMismatchException ex) {
                System.out.println("Entered divisor is not an Integer. Try again.");
                scanner.next();
            }

        }
    }

    private static int divide(Integer a, Integer b) throws CustomArithmeticException {
        try {
            return a / b;
        } catch (ArithmeticException ex) {
            String errorMessage = String.format("Impossible to divide [%s] / [%s].", a, b);
            throw new CustomArithmeticException(errorMessage);
        }
    }

}

class CustomArithmeticException extends RuntimeException {
    public CustomArithmeticException(final String message) {
        super(message);
    }
}