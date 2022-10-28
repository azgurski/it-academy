import java.util.Scanner;

public class HomeWork3Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter finger number and I will show you his name:");
        int finger = scanner.nextInt();

        switch (finger) {
            case 1:
                System.out.println("It's a Thumb.");
                break;
            case 2:
                System.out.println("This is the Index finger.");
                break;
            case 3:
                System.out.println("This is the Middle finger.");
                break;
            case 4:
                System.out.println("This is the Ring finger.");
                break;
            case 5:
                System.out.println("This is the Little finger.");
                break;
            default:
                System.out.println("You entered the wrong finger number. It must be between 1 and 5.");
        }

        scanner.close();
    }
}