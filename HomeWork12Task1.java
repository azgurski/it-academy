import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class HomeWork12Task1 {
    public static void main(String[] args) {
        List<Integer> randomNumbers1 = new ArrayList<>();
        List<Integer> randomNumbers2 = new ArrayList<>();
        List<Integer> sortedNumbers = new ArrayList<>();

        try {
            getRandomNumbers(randomNumbers1, 1_000);
            getRandomNumbers(randomNumbers2, 1_000);

            writeFile("in1.txt", randomNumbers1);
            writeFile("in2.txt", randomNumbers2);

            readFile("in1.txt", sortedNumbers);
            readFile("in2.txt", sortedNumbers);
            sortedNumbers.sort(Comparator.naturalOrder());

            writeFile("out.txt", sortedNumbers);

        } catch (FileNotFoundException ex) {
            System.out.println("Error! Impossible to find a file with this name. Try again.");
            ex.printStackTrace();
        } catch (IOException ex) {
            System.out.println("Error while inputting or outputting data from file! Check your data please.");
            ex.printStackTrace();
        }
    }

    public static void getRandomNumbers(List<Integer> randomList, int numberOfValues) {
        Random random = new Random();
        int randomNumber;

        for (int index = 0; index < numberOfValues; index++) {
            randomNumber = random.nextInt(1, 100_000);
            randomList.add(index, randomNumber);
        }
    }

    public static void writeFile(String nameOfFile, List<Integer> values) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameOfFile, StandardCharsets.UTF_8), 256)) {

            for (int index = 0; index < values.size(); index++) {
                writer.write(values.get(index) + "\n");
            }
        }
    }

    public static void readFile(String nameOfFile, List<Integer> values) throws IOException {
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
    }
}