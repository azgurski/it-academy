import java.util.Scanner;

public class HomeWork2Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите натуральное пятизначное число:");
        int num = scanner.nextInt();

        System.out.println("Третья цифра числа " + num + ": " + (num % 1000 / 100));

        scanner.close();
    }
}