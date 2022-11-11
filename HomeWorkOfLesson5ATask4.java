import java.util.Random;

public class HomeWorkOfLesson5ATask4 {
    public static void main(String[] args) {
        int[][] array = new int[5][5];
        Random random = new Random();
        System.out.println("\nArray: ");

        for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < array.length; columnIndex++) {
                int randomInt = random.nextInt(5) + 1;
                array[rowIndex][columnIndex] = randomInt;
                System.out.print(randomInt + " ");
            }
            System.out.println();
        }

        System.out.println("\nElements of diagonals and results of multiplications: ");

        for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {       // проход по диагоналям только 0-й строки.

            for (int columnIndex = 0; columnIndex < array[rowIndex].length; columnIndex++) {
                int resultMultiplication = 1;

                for (int currentColumn = columnIndex, currentRow = rowIndex; currentRow < array.length && currentColumn < array[currentRow].length; currentRow++, currentColumn++) {
                    int currentColumnValue = array[currentRow][currentColumn];
                    resultMultiplication *= currentColumnValue;

                    if (currentRow == (array.length - 1) || currentColumn == (array[currentRow].length - 1)) {
                        System.out.print(array[currentRow][currentColumn]);
                    } else {
                        System.out.print(array[currentRow][currentColumn] + " * ");
                    }
                }
                System.out.println(" = " + resultMultiplication);
            }
            break;
        }

        for (int columnIndex = 0; columnIndex < array[columnIndex].length; columnIndex++) { // проход по диагоналям только 0-го стоблца, кроме [0][0].

            for (int rowIndex = 0; (rowIndex + 1) < array.length; rowIndex++) {
                int resultMultiplication = 1;

                for (int currentRow = rowIndex + 1, currentColumn = columnIndex; currentColumn < array[columnIndex].length && currentRow < array.length; currentRow++, currentColumn++) {
                    int currentRowValue = array[currentRow][currentColumn];
                    resultMultiplication *= currentRowValue;

                    if (currentRow == (array.length - 1) || currentColumn == (array[currentColumn].length - 1)) {
                        System.out.print(array[currentRow][currentColumn]);
                    } else {
                        System.out.print(array[currentRow][currentColumn] + " * ");
                    }
                }
                System.out.println(" = " + resultMultiplication);
            }
            break;
        }

    }
}
