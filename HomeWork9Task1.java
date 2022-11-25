public class HomeWork9Task1 {
    public static void main(String[] args) {
        Integer[] numbers = {2,3};
        Container<Integer> integerContainer = new Container<>(numbers);
        System.out.println("\nInteger Container");
        integerContainer.first();
        integerContainer.last();
        integerContainer.swap();
        integerContainer.replaceFirst(7);
        integerContainer.replaceLast(12);

        String[] animals = {"Cat", "Dog"};
        Container<String> stringContainer = new Container<>(animals);
        System.out.println("\nString Container");
        stringContainer.first();
        stringContainer.last();
        stringContainer.swap();
        stringContainer.replaceFirst("Elephant");
        stringContainer.replaceLast("Lion");
    }
}

class Container<T> {
    private T[] array;

    Container(T[] array) {
        this.array = array;
    }

    public T first() {
        T firstElement = array[0];
        System.out.println("First element: " + firstElement);

        return firstElement;
    }

    public T last() {
        T lastElement = array[array.length - 1];
        System.out.println("Last element: " + lastElement);

        return lastElement;
    }

    public T[] swap() {
        T newFirstElement = array[array.length - 1];
        T newLastElement = array[0];
        array[0] = newFirstElement;
        array[1] = newLastElement;

        System.out.print("Swapped elements: ");
        for (T element : array) {
            System.out.print(element + " ");
        }

        return array;
    }

    public T[] replaceFirst(T newFirstItem) {

        T itemToReplace = newFirstItem;
        array[0] = itemToReplace;

        System.out.print("\nReplaced first swapped element to the new element " + newFirstItem + ": ");
        for (T element : array) {
            System.out.print(element + " ");
        }

        return array;
    }

    public T[] replaceLast(T newLastItem) {
        T itemToReplace = newLastItem;
        array[array.length - 1] = newLastItem;

        System.out.print("\nReplaced last element to the new element " + newLastItem + ": ");
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();

        return array;
    }
}