public class HomeWork11Task2 {
    public static void main(String[] args) throws DivisorZeroArithmeticException {
        Division result = new Division();
        int resultOfDivision = result.divide(10,0);
        System.out.println("Result of division = " + resultOfDivision);
    }
}

interface Dividable {
    int divide(int dividend, int divisor) throws DivisorZeroArithmeticException;
}

class Division implements Dividable {
    @Override
    public int divide(int dividend, int divisor) throws DivisorZeroArithmeticException {
        try {
            System.out.println("Dividend = " + dividend);
            System.out.println("Divisor = " + divisor);
            return dividend / divisor;
        } catch (ArithmeticException ex) {
            String errorMessage = String.format("Impossible to divide %s to %s.", dividend, divisor);
            throw new DivisorZeroArithmeticException(errorMessage);
        }
    }
}

class DivisorZeroArithmeticException extends Exception {
    public DivisorZeroArithmeticException(final String message) {
        super(message);
    }
}