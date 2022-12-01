import java.util.*;

public class HomeWork10Task1 {
    public static void main(String[] args) {
        Integer[] arrayInt = {2, 2, 6, 6, 8, 2, 17, 8, 4, 4, 2, 8, 2};
        String[] strings = {"a", "b", "a", "c", "V", "v"};

        System.out.println("The number of occurrences of each array element in the array:");
        System.out.println(arrayToMap(arrayInt));
        System.out.println(arrayToMap(strings));
    }

    public static <K> Map<K, Integer> arrayToMap(K[] ks) {
        Map<K, Integer> map = new TreeMap<>();

        for (K element : ks) {

            if (!map.containsKey(element)) {
                map.put(element, 1);
            } else {
                int entryValue = map.get(element);
                map.put(element, ++entryValue);
            }
        }

//        Альтернативная логика через .putIfAbsent():
//        for (Integer element = 0; element < ks.length; element++) {
//            int counterValue = 1;
//
//            for (Integer nextElement = element + 1; nextElement < ks.length; nextElement++) {
//                if (ks[element] == ks[nextElement]) {
//                    counterValue++;
//                }
//            }
//
//            map.putIfAbsent(ks[element], counterValue);
//        }

        return map;
    }
}