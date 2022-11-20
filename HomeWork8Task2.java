public class HomeWork8Task2 {
    public static void main(String[] args) {
        Rose roseRed = new Rose("Rose", 20, "Red", 4);
        roseRed.blooming();

        Rose roseWhite = new Rose("Rose", 16, "White", 6);
        roseWhite.blooming();

        Tulip tulip = new Tulip("Tulip", 8, "Yellow", 14);
        tulip.blooming();

        Lily lily = new Lily("Lily", 24, "White", 5);
        lily.blooming();

        Iris iris = new Iris("Iris", 29, "Violet", 8);
        iris.blooming();

        final Bouquet bouquet = new Bouquet(4);
        bouquet.addFlower(roseRed);
        bouquet.addFlower(roseWhite);
        bouquet.addFlower(tulip);
        bouquet.addFlower(lily);

        bouquet.showTypeAndColorsOfFlowers();
        bouquet.showPriceOfBouquet();
        bouquet.showExpiration();
    }
}

abstract class Flower {
    final String type;
    final int price;
    final String color;
    final int lifeDays;

    public Flower(String type, int price, String color, int lifeDays) {
        this.type = type;
        this.price = price;
        this.color = color;
        this.lifeDays = lifeDays;
    }

    public abstract void blooming();
}

class Bouquet {
    private final Flower[] flowers;
    private int currentElement;

    public Bouquet(final int numberOfFlowers) {
        this.flowers = new Flower[numberOfFlowers];
        this.currentElement = 0;
    }

    public boolean addFlower(final Flower flower) {
        if (currentElement >= flowers.length) {
            return false;
        }

        flowers[currentElement] = flower;
        currentElement++;
        return true;
    }

    public void showTypeAndColorsOfFlowers() {
        System.out.println("\nBouquet consists of:");

        for (int currentElement = 0; currentElement < flowers.length; currentElement++) {
            System.out.println(flowers[currentElement].type + " " + flowers[currentElement].color);
        }
    }

    public void showPriceOfBouquet() {
        int bouquetPrice = 0;

        for (int currentElement = 0; currentElement < flowers.length; currentElement++) {
            bouquetPrice = bouquetPrice + flowers[currentElement].price;
        }

        System.out.println("\nPrice of this bouquet is " + bouquetPrice + " byn.");
    }

    public void showExpiration() {
        int bouquetExpiration = flowers[0].lifeDays;

        for (int currentElement = 0; currentElement < flowers.length; currentElement++) {
            if (flowers[currentElement].lifeDays > bouquetExpiration) {
                bouquetExpiration = flowers[currentElement].lifeDays;
            }
        }

        System.out.println("Bouquet expires in " + bouquetExpiration + " days.");
    }
}

class Rose extends Flower {

    public Rose(final String type, final int price, final String color, final int lifeDays) {
        super(type, price, color, lifeDays);
    }

    @Override
    public void blooming() {
        System.out.println("Flower: " + type + ", color: " + color + ", price: " + price + ", blooms during: " + lifeDays + " days.");
    }
}

class Tulip extends Flower {

    public Tulip(final String type, final int price, final String color, final int lifeDays) {
        super(type, price, color, lifeDays);
    }

    @Override
    public void blooming() {
        System.out.println("Flower: " + type + ", color: " + color + ", price: " + price + ", blooms during: " + lifeDays + " days.");
    }
}

class Lily extends Flower {

    public Lily(final String type, final int price, final String color, final int lifeDays) {
        super(type, price, color, lifeDays);
    }

    @Override
    public void blooming() {
        System.out.println("Flower: " + type + ", color: " + color + ", price: " + price + ", blooms during: " + lifeDays + " days.");
    }
}

class Iris extends Flower {
    public Iris(final String type, final int price, final String color, final int lifeDays) {
        super(type, price, color, lifeDays);
    }

    @Override
    public void blooming() {
        System.out.println("Flower: " + type + ", color: " + color + ", price: " + price + ", blooms during: " + lifeDays + " days.");
    }
}