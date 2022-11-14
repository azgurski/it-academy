import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork7Task4 {
    public static void main(String[] args) {
        System.out.println("Enter your email:");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();

        Pattern pattern = Pattern.compile("(\\w+[\\w.-]*)@([\\w.-]+)\\.([a-z.]{2,6})");
        Matcher matcher = pattern.matcher(email);

        if (matcher.find()) {
            System.out.println("Your email is correct.");
        } else {
            System.out.println("Your email is incorrect.");
        }

        scanner.close();
    }
}