import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HomeWork14Task2 {
    public static void main(String[] args) {
        Comparator<String> comparingByDigitAndReversedFirstLetter = Comparator
                .comparing(o -> o.substring(1));
        comparingByDigitAndReversedFirstLetter = comparingByDigitAndReversedFirstLetter.thenComparing((o1, o2) -> -o1.compareTo(o2));

        List<String> myList = Arrays.asList("a1", "a2", "a3", "b1", "b3", "c2", "c1", "c5");

        Long remainingElementsValue = myList.stream()
                .filter(o -> !o.contains("3"))
                .sorted(comparingByDigitAndReversedFirstLetter)
                .skip(1)
                .limit(myList.size() - 4)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .count();

        System.out.println("Number of remaining elements = " + remainingElementsValue);
    }
}

// В линии 17 мне здесь не нравится абсолютное число элементов 4 = 3 исключенных + 1 последний, хотелось бы как-то указать
// через количество удаленных элементов в 14й строке, наверное, разбив на два стрима с промежуточным подсчетом элементов,
// не прошедших через фильтр. Или число 4 подойдет в явном виде?