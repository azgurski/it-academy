import java.util.Arrays;
import java.util.Collection;

public class HomeWork14Task1 {
    public static void main(String[] args) {
        Collection<Integer> col = Arrays.asList(10, 20, 30, 40, 50);

        Integer maxValue = col.stream().max(Integer::compare).get();
        Integer minValue = col.stream().min(Integer::compare).get();

        Integer sumValues = col.stream().reduce(0, (result, currentElement) -> result + currentElement);
        Integer multiplication = col.stream().reduce(1, (result, currentElement) -> result * currentElement);

        double averageValue = col.stream()
                .reduce(0, (result, currentElement) -> result + (currentElement / col.size()));

        Integer sumDigits = col.stream()
                .map(value -> String.valueOf(value)
                        .chars()
                        .map(Character::getNumericValue)
                        .sum())
                .reduce(0, (result, currentElement) -> result + currentElement);

        System.out.println("min value = " + minValue);
        System.out.println("max value = " + maxValue);
        System.out.println("average value = " + averageValue);
        System.out.println("multiplication of values = " + multiplication);
        System.out.println("sum of values = " + sumValues);
        System.out.println("sum of digits = " + sumDigits);
    }
}