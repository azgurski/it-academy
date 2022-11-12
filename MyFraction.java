package homeWork6.task1;

public class MyFraction {
    public int numerator;
    public int denominator;

    public static void main(String[] args) {
        MyFraction fraction1 = setFraction1();
        MyFraction fraction2 = setFraction2();
        MyFraction fractionOfDoubleValue = setFractionOfDoubleValue();

        MyFraction summation = summation();
        MyFraction multiplication = multiplication();
        MyFraction division = division();

        System.out.println("First Fraction: " + fraction1.numerator + "/" + fraction1.denominator);
        System.out.println("Second Fraction: " + fraction2.numerator + "/" + fraction2.denominator);
        System.out.println("Summation of fractions: " + summation.numerator + "/" + summation.denominator);
        System.out.println("Multiplication of fractions: " + multiplication.numerator + "/" + multiplication.denominator);
        System.out.println("Division of fractions: " + division.numerator + "/" + division.denominator);
    }

    public static MyFraction setFraction1() {
        int numerator1 = 2, denominator1 = 3;
        return new MyFraction(numerator1, denominator1);
    }

    public static MyFraction setFraction2() {
        int numerator2 = 3, denominator2 = 7;
        return new MyFraction(numerator2, denominator2);
    }

    public static MyFraction setFractionOfDoubleValue() {
        double valueOfDouble = 1.3;
        int numeratorOfDouble = (int) (valueOfDouble * 10);
        int denominatorOfDouble = 10;
        return new MyFraction(numeratorOfDouble, denominatorOfDouble);
    }

    public static MyFraction summation() {
        int numeratorAfterSummation = setFraction1().numerator * setFraction2().denominator + setFraction2().numerator * setFraction1().denominator;
        int denominatorAfterSummation = setFraction1().denominator * setFraction2().denominator;
        return new MyFraction(numeratorAfterSummation, denominatorAfterSummation);
    }

    public static MyFraction multiplication() {
        int numeratorAfterMultiplication = setFraction1().numerator * setFractionOfDoubleValue().numerator;
        int denominatorAfterMultiplication = setFraction1().denominator * setFractionOfDoubleValue().denominator;
        return new MyFraction(numeratorAfterMultiplication, denominatorAfterMultiplication);
    }

    public static MyFraction division() {
        int numeratorOfDivision = setFraction1().numerator * setFractionOfDoubleValue().denominator;
        int denominatorOfDivision = setFraction1().denominator * setFractionOfDoubleValue().numerator;
        return new MyFraction(numeratorOfDivision, denominatorOfDivision);
    }

    public MyFraction() {
    }

    public MyFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
}
