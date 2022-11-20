public class HomeWork8Task1 {
    public static void main(String[] args) {
        Man man = new Man();
        man.setName("Alex");
        man.setAge(26);
        man.setWeight(83);
        man.info();

        Student student = new Student();
        student.setYearStartOfStudying(1990);
        student.calculateEndOfStudying(4);
    }
}

class Man {
    private String name;
    private int age;
    private String sex;
    private int weight;

    public void info() {
        System.out.print("Name: " + getName());
        System.out.print("\nAge: " + getAge());
        System.out.print("\nSex: " + getSex());
        System.out.println("\nWeight, kg: " + getWeight());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String getSex() {
        String sex = "M";
        return sex;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

class Student {
    private int year;

    public void calculateEndOfStudying(int duration) {
        System.out.println("\nStart of studying: " + getYearStartOfStudying());
        System.out.println("End of studying: " + (getYearStartOfStudying() + duration));
    }

    public int getYearStartOfStudying() {
        return year;
    }

    public void setYearStartOfStudying(int year) {
        this.year = year;
    }
}