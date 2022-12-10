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
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("Check of return to main : Minimal value = " + threadMin.getMinimal());
                System.out.println("Check of return to main : Maximal value = " + threadMax.getMaximal());
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
    int minimal;

    public ThreadMin(List<Integer> integers) {
        this.listOfNumbers = integers;
    }

    public int getMinimal() {
        return minimal;
    }

    @Override
    public void run() {
        Integer min = Collections.min(listOfNumbers);
        minimal = min;
    }
}

class ThreadMax implements Runnable {
    private List<Integer> listOfNumbers;
    private int maximal;

    public ThreadMax(final List<Integer> integers) {
        this.listOfNumbers = integers;
    }

    public int getMaximal() {
        return maximal;
    }

    @Override
    public void run() {
        Integer max = Collections.max(listOfNumbers);
        maximal = max;
    }
}