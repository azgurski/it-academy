import java.util.Scanner;

public class HomeWork2Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите натуральное двузначное число:");
        int num = scanner.nextInt();

        int sum = (num / 10) + (num % 10);
        System.out.println("Сумма цифр: " + sum);

        scanner.close();
    }
}