import java.io.*;
import java.nio.charset.StandardCharsets;

public class HomeWork12Task2 {
    public static void main(String[] args) {
        File file = new File("hw12_task2.txt");
        writeFile(file);
        countWordsAndPunctuation(file);
    }

    public static void writeFile(File file) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, StandardCharsets.UTF_8), 256)) {
            bufferedWriter.append("In the middle of December, we buy a New Year’s tree, which we decorate with my parents. " +
                    "\nIt’s a tradition because it brings us together and we really have fun doing it. " +
                    "\nAlso, before New Year’s Day, we always clean the house and create a festive atmosphere. " +
                    "\nI like to decorate the house with paper snowflakes, candles, and garlands");
            bufferedWriter.flush();

        } catch (IOException ex) {
            System.out.println("Something went wrong.");
            ex.printStackTrace();
        }
    }

    public static void countWordsAndPunctuation(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8), 512)) {
            int wordsCounter = 1;
            int punctuationCounter = 0;

            while (true) {
                String line = reader.readLine();

                if (line == null) {
                    break;
                }

                for (char symbol : line.toCharArray()) {
                    if (symbol == ' ') {
                        wordsCounter++;
                    }
                    if (symbol == ',' || symbol == '.') {
                        punctuationCounter++;
                    }
                }
            }

            System.out.println("words = " + wordsCounter);
            System.out.println("punctuation = " + punctuationCounter);

        } catch (IOException ex) {
            System.out.println("Something went wrong.");
        }
    }
}