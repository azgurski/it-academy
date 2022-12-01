import java.util.*;

public class HomeWork10Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Tap any word");
        String phrase = scanner.next();

        System.out.println("Number of different characters in a string:");
        System.out.println(getCharsCount(phrase));
    }

    public static Map<Character, Integer> getCharsCount(String s) {
        char[] sAsChar = s.toCharArray();
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char element : sAsChar) {

            if (!map.containsKey(element)) {
                map.put(element, 1);
            } else {
                int entryValue = map.get(element);
                map.put(element, ++entryValue);
            }
        }

        return map;
    }
}