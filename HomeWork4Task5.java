public class HomeWork4Task5 {
    public static void main(String[] args) {
        int hrs = 0, min = 0, result = 0;

        while (hrs < 24) {
            int hrsDig1 = hrs / 10, hrsDig2 = hrs % 10;
            int minDig1 = min / 10, minDig2 = min % 10;

            if (hrsDig1 == minDig2 && hrsDig2 == minDig1) {
                result++;
            }

            min++;
            if (min == 60) {
                min = 0;
                hrs++;
            }
        }

        System.out.println("Число совпадений: " + result);
    }
}