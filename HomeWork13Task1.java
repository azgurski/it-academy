import java.util.*;
import java.util.concurrent.TimeUnit;

public class HomeWork13Task1 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        createArray(integers);

        ThreadMin threadMin = new ThreadMin(integers);
        ThreadMax threadMax = new ThreadMax(integers);
        Thread thread1 = new Thread(threadMin);
        Thread thread2 = new Thread(threadMax);

        thread1.start();
        thread2.start();

        try {
            do {
                TimeUnit.MILLISECONDS.sleep(1_000);
                System.out.println("Check of return to main : Minimal value = " + threadMin.getMinValue());
                System.out.println("Check of return to main : Maximal value = " + threadMax.getMaxValue());
            } while (thread1.isAlive() || thread2.isAlive());

        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void createArray(List<Integer> listToAdd) {
        System.out.println("To create an array, you need to put 5 numbers separated by space.");
        Scanner scanner = new Scanner(System.in);

        try {
            for (int i = 0; i < 5; i++) {
                int number = scanner.nextInt();
                listToAdd.add(number);
            }

        } catch (InputMismatchException ex) {
            System.out.println("It seems that you put not 5 numbers of Integer's type... I will do what is in my power or you should try again.");
            scanner.close();
        }

        scanner.close();
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

    @Override
    public void run() {
        Integer minFromCollection = Collections.min(listOfNumbers);
        minValue = minFromCollection;
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

    @Override
    public void run() {
        Integer maxFromCollection = Collections.max(listOfNumbers);
        maxValue = maxFromCollection;
    }
}