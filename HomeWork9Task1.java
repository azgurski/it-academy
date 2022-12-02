public class HomeWork9Task1 {
    public static void main(String[] args) {

        Pair<String, Integer> pair = new Pair<>("Minsk", 2023);
       
        pair.first();
        pair.second();
        pair.swap();
        pair.replaceFirst(true);
        pair.replaceSecond(32.1);
    }
}

class Pair<A, B> {
    private A item1;
    private B item2;

    public Pair(A item1, B item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public A getItem1() {
        return item1;
    }

    public B getItem2() {
        return item2;
    }

    public A first() {
        A first = getItem1();
        System.out.println("First element = " + first);
        return first;
    }

    public B second() {
        B second = getItem2();
        System.out.println("Second element = " + second);
        return second;
    }

    public void swap() {
        B newItem1 = getItem2();
        A newItem2 = getItem1();

        System.out.println("\nSwapped first element = " + newItem1);
        System.out.println("Swapped second element = " + newItem2);
    }

    public <A> void replaceFirst(A itemToReplaceFirst) {
        A replacedFirstItem = itemToReplaceFirst;
        System.out.println("\nAfter replacing first element = " + replacedFirstItem + " " + getItem2());
    }

    public <B> void replaceSecond(B itemToReplaceSecond) {
        B replacedSecondItem = itemToReplaceSecond;
        System.out.println("After replacing second element = " + getItem1() + " " + replacedSecondItem);
    }
}
