import java.util.*;

public class HomeWork10Task3 {
    public static void main(String[] args) {
        User user1 = new User("John", "Smith");
        User user2 = new User("John", "Smith");
        User user3 = new User("Adam", "Vector");

        Set<User> usersHash = new HashSet<>();
        usersHash.add(user1);
        usersHash.add(user2);
        usersHash.add(user3);
        System.out.println("Users(Hash):");
        usersHash.forEach(System.out::println);

        Set<User> usersTree = new TreeSet<>();
        usersTree.add(user1);
        usersTree.add(user2);
        usersTree.add(user3);
        System.out.println("\nUsers(Tree) sorted by the first name:");
        usersTree.forEach(System.out::println);
    }
}

class User implements Comparable<User> {
    private String firstName;
    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;
        boolean isFirstNameEquals = Objects.equals(getFirstName(), user.getFirstName());
        boolean isLastNameEquals = Objects.equals(getLastName(), user.getLastName());
        return isFirstNameEquals && isLastNameEquals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName());
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public int compareTo(User anotherUser) {
        return this.firstName.compareTo(anotherUser.getFirstName());
    }
}
