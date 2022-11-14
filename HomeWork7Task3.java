import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork7Task3 {
    public static void main(String[] args) {
        String string = "«Listen to the news from today, read the text at the same time! " +
                "\nListen to the news from today - without reading the text.»";

        Pattern pattern = Pattern.compile("[.,?!:;«»-]");
        Matcher matcher = pattern.matcher(string);

        int result = 0;
        while (matcher.find()) {
            result++;
        }

        System.out.println(string);
        System.out.println("Total of punctuation marks: " + result);
    }
}