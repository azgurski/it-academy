import java.util.*;
import java.util.concurrent.*;

public class HomeWork15 {
    public static void main(String[] args) {
        try {
            Integer[][] matrix = setMatrixSize();
            fillMatrix(matrix);

            ExecutorService parallelMultiplication = Executors.newFixedThreadPool(2);
            Callable<Long> callableRows = new RowsSumMultiplicationsCallable(matrix);
            Callable<Long> callableColumns = new ColumnsSumMultiplicationsCallable(matrix);

            Future<Long> futureRows = parallelMultiplication.submit(callableRows);
            Future<Long> futureColumns = parallelMultiplication.submit(callableColumns);
            parallelMultiplication.shutdown();

            compare(futureRows, futureColumns);
        } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
        } catch (ExecutionException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static Integer[][] setMatrixSize() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("To set matrix size, tap the number of rows and columns separated by space from 2 and more:");
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();

            if (rows < 2 || columns < 2) {
                throw new IllegalArgumentException("Type of entered data doesn't belong to Integer or " +
                        "value of one or two of them is less than 2. " +
                        "You have to restart the program.");
            }

            Integer[][] matrix = new Integer[rows][columns];
            return matrix;
        }
    }

    public static void fillMatrix(Integer[][] matrix) {
        Random random = new Random();
        System.out.println("\nYour array is:");

        for (int currentRowIndex = 0; currentRowIndex < matrix.length; currentRowIndex++) {
            for (int currentColumnIndex = 0; currentColumnIndex < matrix[currentRowIndex].length; currentColumnIndex++) {
                Integer randomValue = random.nextInt();
                matrix[currentRowIndex][currentColumnIndex] = randomValue;
                System.out.print(randomValue + " ");
            }
            System.out.println();
        }
    }

    public static void compare(Future<Long> futureRows, Future<Long> futureColumns) throws ExecutionException, InterruptedException {
        System.out.println("\nSum of multiplications of values from every row = " + futureRows.get());
        System.out.println("Sum of multiplications of values from every column = " + futureColumns.get());

        if (futureRows.get() > futureColumns.get()) {
            System.out.println("\nSum of multiplications of values from rows = " + futureRows.get()
                    + " is more than from columns = " + futureColumns.get());
        } else if (futureColumns.get() > futureRows.get()) {
            System.out.println("\nSum of multiplications of values from columns = " + futureColumns.get()
                    + " is more than from rows = " + futureRows.get());
        } else {
            System.out.println("\nSum of multiplications of values from rows equals to columns = " + futureRows.get());
        }
    }
}

class RowsSumMultiplicationsCallable implements Callable<Long> {
    private final Integer[][] matrix;

    RowsSumMultiplicationsCallable(Integer[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public Long call() {
        long sumByRows = 0;

        for (final Integer[] integers : matrix) {
            int currentMultiplicationResult = 1;

            for (final Integer integer : integers) {
                currentMultiplicationResult *= integer;
            }
            sumByRows += currentMultiplicationResult;
        }
        return sumByRows;
    }
}

class ColumnsSumMultiplicationsCallable implements Callable<Long> {
    private final Integer[][] matrix;

    ColumnsSumMultiplicationsCallable(Integer[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    public Long call() {
        long sumByColumns = 0;

        for (int currentColumnIndex = 0; currentColumnIndex < matrix[0].length; currentColumnIndex++) {
            int currentMultiplicationResult = 1;

            for (Integer[] currentRowArray : matrix) {
                currentMultiplicationResult *= currentRowArray[currentColumnIndex];
            }
            sumByColumns += currentMultiplicationResult;
        }
        return sumByColumns;
    }
}