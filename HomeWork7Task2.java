import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork7Task2 {
    public static void main(String[] args) {
        System.out.println("Enter your string: ");

        Scanner scanner = new Scanner(System.in);
        StringBuilder stringToFormat = new StringBuilder(scanner.nextLine());

        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(stringToFormat);

        String stringWithoutExtraSpacesInside = matcher.replaceAll(" ");
        System.out.println("Your string without extra spaces:\n" + stringWithoutExtraSpacesInside.trim());
    }
}