package HomeWork6;

public class Fraction {
    public int numerator;
    public int denominator;

    public static void main(String[] args) {
        Fraction fraction1 = new Fraction(2, 3);
        Fraction fraction2 = new Fraction(6, 7);
        double valueOfDouble = 1.3;
        Fraction fractionOfDoubleValue = setFractionOfDoubleValue(valueOfDouble);

        Fraction fraction1AsText = showFractionAsText("First fraction: ", fraction1.numerator, fraction1.denominator);
        Fraction fraction2AsText = showFractionAsText("Second fraction: ", fraction2.numerator, fraction2.denominator);
        System.out.println("Double number: " + valueOfDouble);

        Fraction summation = summation(fraction1.numerator, fraction1.denominator, fraction2.numerator, fraction2.denominator);
        Fraction multiplication = multiplication(fraction1.numerator, fraction1.denominator, fractionOfDoubleValue.numerator, fractionOfDoubleValue.denominator);
        Fraction division = division(fraction1.numerator, fraction1.denominator, fractionOfDoubleValue.numerator, fractionOfDoubleValue.denominator);

        System.out.println("\nSummation of fractions: " + summation.numerator + "/" + summation.denominator);
        System.out.println("Multiplication of First fraction and double number " + valueOfDouble + ": " + multiplication.numerator + "/" + multiplication.denominator);
        System.out.println("Division of First fraction and double number " + valueOfDouble + ": " + division.numerator + "/" + division.denominator);
    }

    public static Fraction showFractionAsText(String textToShow, int numerator, int denominator) {
        System.out.println(textToShow + numerator + "/" + denominator);
        return new Fraction(numerator, denominator);
    }

    public static Fraction setFractionOfDoubleValue(double valueOfDouble) {
        int numeratorOfDouble = (int) (valueOfDouble * 10);
        int denominatorOfDouble = 10;
        return new Fraction(numeratorOfDouble, denominatorOfDouble);
    }

    public static Fraction summation(int numerator1, int denominator1, int numerator2, int denominator2) {
        int numeratorOfSummation = numerator1 * denominator2 + numerator2 * denominator1;
        int denominatorOfSummation = denominator1 * denominator2;
        return new Fraction(numeratorOfSummation, denominatorOfSummation);
    }

    public static Fraction multiplication(int numerator1, int denominator1, int numeratorOfDouble, int denominatorOfDouble) {
        int numeratorOfMultiplication = numerator1 * numeratorOfDouble;
        int denominatorOfMultiplication = denominator1 * denominatorOfDouble;
        return new Fraction(numeratorOfMultiplication, denominatorOfMultiplication);
    }

    public static Fraction division(int numerator1, int denominator1, int numeratorOfDouble, int denominatorOfDouble) {
        int numeratorOfDivision = numerator1 * denominatorOfDouble;
        int denominatorOfDivision = denominator1 * numeratorOfDouble;
        return new Fraction(numeratorOfDivision, denominatorOfDivision);
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
}
