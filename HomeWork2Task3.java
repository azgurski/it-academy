import java.util.Scanner;

public class HomeWork2Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите натуральное трёхзначное число:");
        int num = scanner.nextInt();

        int FirstDig = num / 100;
        int SecondDig = num / 10 % 10;
        int ThirdDig = num % 10;
        System.out.println("Сумма цифр числа " + num + ": " + (FirstDig + SecondDig + ThirdDig));

        scanner.close();
    }
}