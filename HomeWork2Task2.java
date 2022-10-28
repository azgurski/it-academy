import java.util.Scanner;

public class HomeWork2Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите два натуральных числа:");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int div = num1 / num2, mod = num1 % num2;

        System.out.println("Результат деления: " + div + ", частное: " + mod + ".");

        scanner.close();
    }
}