public class HomeWork9Task1 {
    public static void main(String[] args) {
        Pair pair = new Pair("Minsk", 2023);

        pair.getFirst();
        pair.getSecond();
        pair.swap();
        pair.replaceFirst(true);
        pair.replaceSecond(32.1);
    }
}

class Pair<T> {
    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        System.out.println("First element = " + first);
        return first;
    }

    public T getSecond() {
        System.out.println("Second element = " + second);
        return second;
    }

    public void swap() {
        T current = this.first;
        this.first = this.second;
        this.second = current;
        System.out.println("\nSwapped first element = " + first);
        System.out.println("Swapped second element = " + second);
    }

    public void replaceFirst(T newFirst) {
        this.first = newFirst;
        System.out.println("\nNew first element = " + first);
    }

    public void replaceSecond(T newSecond) {
        this.second = newSecond;
        System.out.println("New second element = " + second);
    }
}