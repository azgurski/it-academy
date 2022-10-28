import java.util.Scanner;

public class HomeWork3Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your integer:");
        int num = scanner.nextInt();

        if (num % 2 == 0) {
            System.out.println("Your number is even.");
        } else {
            System.out.println("Your number is odd.");
        }

        scanner.close();
    }
}
