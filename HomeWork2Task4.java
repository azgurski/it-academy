import java.util.Scanner;

public class HomeWork2Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите натуральное число:");
        int num = scanner.nextInt();

        System.out.println("Последняя цифра числа " + num + ": " + (num % 10));

        scanner.close();
    }
}
