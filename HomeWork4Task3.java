import java.util.Scanner;

public class HomeWork4Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите натуральное число от 1 до 170:");
        int num = scanner.nextInt();
        double multi = 1;

        if (num >= 1 && num <= 170) {
            for (int counter = 1; counter <= num; counter++) {
                multi = multi * counter;
            }
            System.out.println("Факториал введенного числа " + num + " = " + multi);
        } else {
            System.out.println("Проверьте введённое число и введите новое от 1 до 170.");
        }

        scanner.close();
    }
}