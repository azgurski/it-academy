public class HomeWork11Task2 {
    public static void main(String[] args) throws MyArithmeticException {
        Division result = new Division();
        int resultOfDivision = result.divide(10,6);
        System.out.println("Result of division = " + resultOfDivision);
    }
}

interface Dividable {
    int divide(int dividend, int divisor) throws MyArithmeticException;
}

class Division implements Dividable {
    @Override
    public int divide(int dividend, int divisor) throws MyArithmeticException {
        try {
            System.out.println("Dividend = " + dividend);
            System.out.println("Divisor = " + divisor);
            return dividend / divisor;
        } catch (ArithmeticException ex) {
            String errorMessage = String.format("Impossible to divide [%s] / [%s].", dividend, divisor);
            throw new MyArithmeticException(errorMessage);
        }
    }
}

class MyArithmeticException extends Exception {
    public MyArithmeticException(final String message) {
        super(message);
    }
}