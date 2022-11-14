import java.util.Scanner;

public class HomeWork7Task1 {
    public static void main(String[] args) {
        System.out.println("Enter your string: ");

        Scanner scanner = new Scanner(System.in);
        String stringByUser = scanner.nextLine();
        StringBuilder stringForChange = new StringBuilder(stringByUser);

        if (stringByUser.startsWith("abc")) {
            stringForChange.replace(0, 3, "www");
            System.out.println("New string:\n" + stringForChange);
        } else {
            stringForChange.append("ttt");
            System.out.println("New string:\n" + stringForChange);
        }

        scanner.close();
    }
}