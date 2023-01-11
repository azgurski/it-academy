import java.lang.annotation.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class HomeWork19Task2 {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException, InstantiationException {
        Customer customer = create(Customer.class, "Vasya", "Pp");
        System.out.println("customer = " + customer);
    }

    private static <T> T create(Class<T> clazz, String firstName, String lastName) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<T> constructor = clazz.getDeclaredConstructor(String.class, String.class);

        Annotation[] classAnnotations = clazz.getAnnotations();
        boolean shouldBeValidated = Stream.of(classAnnotations).anyMatch(a -> a.annotationType().equals(ValidatedClass.class));

        if (shouldBeValidated) {
            Parameter parameterFirstName = constructor.getParameters()[0];

            PatternValidation patternFirstNameValidation = (PatternValidation) Stream.of(parameterFirstName.getAnnotations())
                    .filter(a -> a.annotationType().equals(PatternValidation.class))
                    .findFirst()
                    .orElse(null);

            if (patternFirstNameValidation != null) {
                Pattern patternFirstName = Pattern.compile(patternFirstNameValidation.pattern());
                Matcher matcherFirstName = patternFirstName.matcher(firstName);

                if (!matcherFirstName.matches()) {
                    String errorMessage = String.format(patternFirstNameValidation.errorMessageFirstName(), firstName, patternFirstNameValidation.pattern());
                    throw new IllegalAccessException(errorMessage);
                }

                Parameter parameterLastName = constructor.getParameters()[1];
                PatternValidation patternLastNameValidation = (PatternValidation) Stream.of(parameterLastName.getAnnotations())
                        .filter(a -> a.annotationType().equals(PatternValidation.class))
                        .findFirst()
                        .orElse(null);

                if (patternLastNameValidation != null) {
                    Pattern patternLastName = Pattern.compile(patternLastNameValidation.pattern());
                    Matcher matcherLastName = patternLastName.matcher(lastName);

                    if (!matcherLastName.matches()) {
                        String errorMessage = String.format(patternLastNameValidation.errorMessageLastName(), lastName, patternLastNameValidation.pattern());
                        throw new IllegalAccessException(errorMessage);
                    }
                }
            }
        }
        return constructor.newInstance(firstName, lastName);
    }
}

@ValidatedClass
class Customer {
    private String firstName;
    private String lastName;

    Customer(@PatternValidation(pattern = "[a-zA-Z]{1,25}") String firstName,
             @PatternValidation(pattern = "[a-zA-Z1-9]{3,10}") String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface ValidatedClass {
}

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER})
@interface PatternValidation {
    String pattern();
    String errorMessageFirstName() default "\nFirst name [%s] is not matched by pattern [%s]. " +
            "\nIt must be between 1 and 25 symbols and consist of letters only, from aA to zZ. Start again please.";
    String errorMessageLastName() default "\nLast name [%s] is not matched by pattern [%s]. " +
            "\nIt must be between 3 and 10 symbols and consist of letters from aA to zZ or/and digits from 1 to 9. Start again please.";
}