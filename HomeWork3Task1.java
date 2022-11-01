import java.util.Scanner;

public class HomeWork3Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter three numbers:");
        float numA = scanner.nextInt();
        float numB = scanner.nextInt();
        float numC = scanner.nextInt();

        if ((numA - numB) * (numC - numA) >= 0) {
            System.out.println("The middle number of them is: " + numA);
        } else if ((numB - numA) * (numC - numB) >= 0) {
            System.out.println("The middle number of them is: " + numB);
        } else {
            System.out.println("The middle number of them is: " + numC);
        }

        scanner.close();
    }
}
