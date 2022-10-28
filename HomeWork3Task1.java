import java.util.Scanner;

public class HomeWork3Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three numbers separated by Enter:");
        float numA = scanner.nextInt();
        float numB = scanner.nextInt();
        float numC = scanner.nextInt();

        if ((numA > numB && numA < numC) || (numA < numB && numA > numC)) {
            System.out.println("The middle number of them is: " + numA);
        }
        if ((numB > numA && numB < numC) || (numB < numA && numB > numC)) {
            System.out.println("The middle number of them is: " + numB);
        }
        if ((numC > numA && numC < numB) || (numC < numA && numC > numB)) {
            System.out.println("The middle number of them is: " + numC);
        }

        scanner.close();
    }
}