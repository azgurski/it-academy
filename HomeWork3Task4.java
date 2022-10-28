import java.util.Scanner;

public class HomeWork3Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number in seconds");
        int numSec = scanner.nextInt();

        if (numSec >= 0 && numSec < 60) {
            System.out.println(numSec + " sec");
        }
        if (numSec >= 60 && numSec < 3600) {
            System.out.println(numSec / 60 + " min " + numSec % 60 + " sec");
        }
        if (numSec >= 3600) {
            System.out.println(numSec / 3600 + " hr " + numSec % 3600 / 60 + " min " + (numSec - 3600) % 60 + " sec ");
        } else
            System.out.println("Check your number in seconds");
        scanner.close();
    }
}
