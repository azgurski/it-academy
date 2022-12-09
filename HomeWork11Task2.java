public class HomeWork11Task2 {
    public static void main(String[] args) throws CustomException {
        Division result = new Division();
        int resultOfDivision = result.divide(10,0);
        System.out.println("Result of division = " + resultOfDivision);
    }
}

interface Dividable {
    int divide(int dividend, int divisor) throws CustomException;
}

class Division implements Dividable {
    @Override
    public int divide(int dividend, int divisor) throws CustomException {
        try {
            System.out.println("Dividend = " + dividend);
            System.out.println("Divisor = " + divisor);
            return dividend / divisor;
        } catch (Exception ex) {
            String errorMessage = String.format("Impossible to divide [%s] / [%s].", dividend, divisor);
            throw new CustomException(errorMessage);
        }
    }
}

class CustomException extends Exception {
    public CustomException(final String message) {
        super(message);
    }
}