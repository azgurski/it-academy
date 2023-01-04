import java.lang.reflect.Modifier;
import java.util.*;

public class HomeWork19Task1 {
    public static void main(String[] args) {
        System.out.println("==Information about " + LinkedList.class.getSimpleName() + " class==");

        System.out.println("\nFields:");
        Arrays.stream(LinkedList.class.getDeclaredFields())
                .forEach(System.out::println);

        System.out.println("\nSuperclass:");
        System.out.println(LinkedList.class.getSuperclass());

        System.out.println("\nMethods:");
        Arrays.stream(LinkedList.class.getMethods())
                .forEach(System.out::println);

        System.out.println("\nConstructors:");
        Arrays.stream(LinkedList.class.getConstructors())
                .forEach(System.out::println);

        System.out.println("\nInner classes:");
        Arrays.stream(LinkedList.class.getDeclaredClasses())
                .forEach(innerClass -> {
            System.out.println(Modifier.toString(innerClass.getModifiers()) + " class " + innerClass.getSimpleName());
        });
    }
}