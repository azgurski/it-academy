import java.util.Scanner;

public class HomeWork2Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите натуральное трёхзначное число:");
        int num = scanner.nextInt();

        int firstDig = num / 100;
        int secondDig = num / 10 % 10;
        int thirdDig = num % 10;
        System.out.println("Сумма цифр числа " + num + ": " + (firstDig + secondDig + thirdDig));

        scanner.close();
    }
}
