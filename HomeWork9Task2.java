import java.util.Random;

public class HomeWork9Task2 {
    public static void main(String[] args) {
        Integer[][] array = new Integer[5][5];
        Iterator<Integer> iterator = new Iterator<>(array);

        Random random = new Random();
        System.out.println("Array: ");

        for (int rowIndex = 0; rowIndex < array.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < array.length; columnIndex++) {
                int randomInt = random.nextInt(9) + 1;
                array[rowIndex][columnIndex] = randomInt;
                System.out.print(randomInt + " ");
            }
            System.out.println();
        }
        System.out.print("\n");

        while (iterator.hasNext()) {
            iterator.next();
        }
    }
}

class Iterator<K> {

    int currentRowIndex = 0;
    int currentColumnIndex = 0;

    private K[][] array;

    public Iterator(K[][] array) {
        this.array = array;
    }

    public boolean hasNext() {
        return currentRowIndex < array.length;
    }

    public K next() {

        K element = array[currentRowIndex][currentColumnIndex];
        currentColumnIndex++;

        while (currentRowIndex < array.length && currentColumnIndex >= array[currentRowIndex].length) {
            currentColumnIndex = 0;
            currentRowIndex++;
        }
        System.out.print(element + " ");

        return element;
    }
}