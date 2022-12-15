import java.util.*;
import java.util.concurrent.TimeUnit;

public class HomeWork13Task1 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        createArray(integers);

        ThreadMin threadForMinValue = new ThreadMin(integers);
        ThreadMax threadForMaxValue = new ThreadMax(integers);
        Thread threadSearchMin = new Thread(threadForMinValue);
        Thread threadSearchMax = new Thread(threadForMaxValue);

        threadSearchMin.start();
        threadSearchMax.start();

        try {
            do {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println("Check of return to main : Min value = " + threadForMinValue.getMinValue());
                System.out.println("Check of return to main : Max value = " + threadForMaxValue.getMaxValue());
            } while (threadSearchMin.isAlive() || threadSearchMax.isAlive());

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void createArray(List<Integer> listToAdd) {
        System.out.println("To create an array, you need to put 5 numbers separated by space.");

        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < 5; i++) {
                int number = scanner.nextInt();
                listToAdd.add(number);
            }

        }
        catch (InputMismatchException ex) {
            System.out.println("It seems that you put not 5 numbers of Integer's type... I make all what is in my power or you should start again.");
        }
    }
}

class ThreadMin implements Runnable {
    private List<Integer> listOfNumbers;
    private int minValue;

    public ThreadMin(List<Integer> integers) {
        this.listOfNumbers = integers;
    }

    public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    @Override
    public void run() {
        setMinValue(Collections.min(listOfNumbers));
    }
}

class ThreadMax implements Runnable {
    private List<Integer> listOfNumbers;
    private int maxValue;

    public ThreadMax(final List<Integer> integers) {
        this.listOfNumbers = integers;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public void run() {
        setMaxValue(Collections.max(listOfNumbers));
    }
}