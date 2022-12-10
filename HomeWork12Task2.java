import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWork12Task2 {
    public static void main(String[] args) {
        try {
            writeFile("hw12_task2.txt");
            countWordsAndPunctuation("hw12_task2.txt");

        } catch (FileNotFoundException ex) {
            System.out.println("Error! Impossible to find a file with this name. Try again.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error while inputting or outputting data from file! Check your data please.");
            ex.printStackTrace();
        }
    }

    public static void writeFile(String file) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8), 256)) {
            bufferedWriter.append("In the middle of December, we buy a New Year’s tree, which we decorate with my parents. " +
                    "\nIt’s a tradition because it brings us together and we really have fun doing it. " +
                    "\nAlso, before New Year’s Day, we always clean the house and create a festive atmosphere. " +
                    "\nI like to decorate the house with paper snowflakes, candles, and garlands");
            bufferedWriter.flush();
        }
    }

    public static void countWordsAndPunctuation(String file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8), 512)) {
            int wordsCounter = 0;
            int punctuationCounter = 0;

            Pattern patternPunctuation = Pattern.compile("[.,?!:;«»-]");
            Pattern patternWords = Pattern.compile("[\\w’]+");

            while (true) {
                String line = reader.readLine();

                if (line == null) {
                    break;
                }

                Matcher matcherWords = patternWords.matcher(line);
                while (matcherWords.find()) {
                    wordsCounter++;
                }

                Matcher matcherPunctuation = patternPunctuation.matcher(line);
                while (matcherPunctuation.find()) {
                    punctuationCounter++;
                }
            }

            System.out.println("Words = " + wordsCounter);
            System.out.println("Punctuation = " + punctuationCounter);
        }
    }
}