import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HomeWork12Task1 {
    public static void main(String[] args) throws IOException {
        File in1File = new File("in1_1.txt");
        File in2File = new File("in2_1.txt");
        File outFile = new File("out_1.txt");

        writeFilesWithRandomNumbers(in1File);
        writeFilesWithRandomNumbers(in2File);
        writeFileWithSortedNumbers(outFile, readFilesWithRandomNumbers(in1File, in2File));
    }

    public static void writeFilesWithRandomNumbers(File inFile) {
        Random random = new Random();
        int[] randomNumbers = new int[1_000];
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(1, 100_000);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(inFile, StandardCharsets.UTF_8), 256)) {
            for (int i = 0; i < randomNumbers.length; i++) {
                writer.write(randomNumbers[i] + "\n");
            }
        } catch (IOException ex) {
            System.out.println("Something went wrong.");
            ex.printStackTrace();
        }
    }

    public static List<Integer> readFilesWithRandomNumbers(File in1File, File in2File) {
        List<Integer> numbersFromFiles = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(in1File, StandardCharsets.UTF_8), 512)) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                int number = Integer.valueOf(line);
                numbersFromFiles.add(number);
            }

        } catch (IOException ex) {
            System.out.println("Something went wrong.");
            ex.printStackTrace();
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(in2File, StandardCharsets.UTF_8), 512)) {
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }

                int number = Integer.valueOf(line);
                numbersFromFiles.add(number);
            }

        } catch (IOException ex) {
            System.out.println("Something went wrong.");
            ex.printStackTrace();
        }

        return numbersFromFiles;
    }

    public static void writeFileWithSortedNumbers(File outFile, List<Integer> numbersFromFiles) {
        int arrayOfNumbers[] = new int[numbersFromFiles.size()];
        for (int currentIndex = 0; currentIndex < numbersFromFiles.size(); currentIndex++) {
            arrayOfNumbers[currentIndex] = numbersFromFiles.get(currentIndex);
        }
        Arrays.sort(arrayOfNumbers);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outFile, StandardCharsets.UTF_8), 256)) {
            for (int i = 0; i < arrayOfNumbers.length; i++) {
                writer.write(arrayOfNumbers[i] + "\n");
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}