public class HomeWork4Task2 {
    public static void main(String[] args) {

        for (int row = 1; row <= 5; row++) {
            for (int star = 1; star < row; star++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}