import java.util.Scanner;

public class HomeWork2Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите натуральное четырёхзначное число:");
        int num = scanner.nextInt();
        int firstTwoDig = num / 100, secondTwoDig = num % 100;

        System.out.println("Сумма чисел, составленных из первых двух и последних двух цифр числа " + num + " : " + (firstTwoDig + secondTwoDig));

        scanner.close();
    }
}
