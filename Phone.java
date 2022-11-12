package HomeWork6;

public class Phone {
    int number;
    String model;
    int weight;
    String name;
    String phoneNumber;

    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        Phone phone3 = new Phone();

        phone1.listOfPhones(1, "Sony", 150);
        phone2.listOfPhones(2, "Samsung", 300);
        phone3.listOfPhones(3, "iPhone", 450);

        phone1.receiveCall("Alex");
        phone2.receiveCall("Kate");
        phone3.receiveCall("Mike");

        phone1.getNumber(1);
        phone2.getNumber(2);
        phone3.getNumber(3);

        phone1.receiveCall("Alex", "+375 29 612 24 98");
        phone2.receiveCall("Kate", "+375 44 553 30 77");
        phone3.receiveCall("Mike", "+375 33 761 01 15");

        Phone phoneNumbers = new Phone();
        phoneNumbers.sendMessage("+375 29 612 24 98", "+375 44 553 30 77", "+375 33 761 01 15");
    }

    public void listOfPhones(int number, String model, int weight) {
        System.out.println("Phone number " + number + ", model " + model + ", weight " + weight);
    }

    public void receiveCall(String name) {
        System.out.println(name + " is calling..");
    }

    public void receiveCall(String name, String phoneNumber) {
        System.out.println(name + " is calling from " + phoneNumber + "..");
    }

    public int getNumber(int number) {
        System.out.println("Phone number is " + number);
        return number;
    }

    static void sendMessage(String... phoneNumbers) {
        for (int counterOfPhoneNumbers = 0; counterOfPhoneNumbers < phoneNumbers.length; counterOfPhoneNumbers++) {
            System.out.println("Send message to " + phoneNumbers[counterOfPhoneNumbers]);
        }
    }

    public Phone() {
    }

    public Phone(int number) {
        this.number = number;
    }

}