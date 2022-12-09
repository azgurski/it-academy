import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class HomeWork12Task1 {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList();

        try {
            writeFilesWithRandomNumbers("in1.txt");
            writeFilesWithRandomNumbers("in2.txt");
            readFilesWithRandomNumbers("in1111.txt", values);
            readFilesWithRandomNumbers("in2.txt", values);
            writeFileWithSortedNumbers("out.txt", values);

        } catch (FileNotFoundException ex) {
            System.out.println("Error! Impossible to find a file with this name. Try again.");
            ex.printStackTrace();
        } catch (NullPointerException | IOException ex) {
            System.out.println("Error while inputting or outputting data from file! Check your data please.");
            ex.printStackTrace();
        }
    }

    public static void writeFilesWithRandomNumbers(String nameOfFile) throws IOException {
        Random random = new Random();
        int[] randomNumbers = new int[1_000];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(1, 100_000);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameOfFile, StandardCharsets.UTF_8), 256)) {
            for (int i = 0; i < randomNumbers.length; i++) {
                writer.write(randomNumbers[i] + "\n");
            }
        }
    }

    public static List<Integer> readFilesWithRandomNumbers(String nameOfFile, List<Integer> values) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(nameOfFile, StandardCharsets.UTF_8), 512)) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                int number = Integer.valueOf(line);
                values.add(number);
            }
        }

        return values;
    }

    public static void writeFileWithSortedNumbers(String nameOfFile, List<Integer> values) throws IOException {
        values.sort(Comparator.naturalOrder());

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameOfFile, StandardCharsets.UTF_8), 256)) {
            for (int i = 0; i < values.size(); i++) {
                writer.write(values.get(i) + "\n");
            }
        }
    }
}