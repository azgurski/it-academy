public class HomeWork4Task4 {
    public static void main(String[] args) {
        int result = 0;

        for (int num = 0; num <= 100000; num++) {
            boolean num13 = ((num / 1000 == 13) || (num / 100 % 100 == 13) || (num / 10 % 100 == 13) || (num % 100 == 13));
            // проверка на наличие числа 13 в каждом разряде: 13***, *13**, **13*, ***13

            boolean num4 = ((num / 10000 == 4) || (num / 1000 % 10 == 4) || (num / 100 % 10 == 4) || (num / 10 % 10 == 4) || (num % 10 == 4));
            // проверка на наличие цифры 4 в каждом разряде: 4****, *4***, **4**, ***4*, ****4

            if (num13 || num4) {
                result++;
            }
        }

        System.out.println("Число единиц техники, подлежащих исключению: " + result);
    }
}