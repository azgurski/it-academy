import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class HomeWork13Task2 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        Generator generator = new Generator(integers);
        Thread thread = new Thread(generator);
        thread.start();
    }
}

class Generator extends Thread {
    private int numberToAdd;
    private int currentIndex;
    private final int maxIndex = 99;
    private List<Integer> integers;

    Generator(List<Integer> integers) {
        this.integers = integers;
    }

    public int getNumberToAdd() {
        return numberToAdd;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public int getMaxIndex() {
        return maxIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public void setNumberToAdd(int numberToAdd) {
        this.numberToAdd = numberToAdd;
    }

    @Override
    public void run() {
        Random random = new Random();

        try {
            do {
                setNumberToAdd(random.nextInt(1, 1_000));
                integers.add(getNumberToAdd());
                System.out.println("For index " + getCurrentIndex() + " it was added number " + getNumberToAdd());
                setCurrentIndex(getCurrentIndex() + 1);

                TimeUnit.MILLISECONDS.sleep(200);
            } while (getCurrentIndex() <= getMaxIndex());

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}