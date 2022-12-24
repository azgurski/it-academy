import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class HomeWork17Task2 {
    public static void main(final String[] args) {
        Basket basket = new Basket(new HashMap<>(10));
        Category sportCategory = new Category("Sport", new ArrayList<>(10));
        Category foodCategory = new Category("Food", new ArrayList<>(10));

        addProductsOfSport(sportCategory);
        addProductsOfFood(foodCategory);

        basket.purchaseProducts(sportCategory.getProductsCatalogue());
        basket.purchaseProducts(foodCategory.getProductsCatalogue());

        basket.getPurchasedProducts();
    }

    public static void addProductsOfSport(final Category category) {
        category.addProduct(new Product("Ball", 9, 4.5));
        category.addProduct(new Product("Sneakers", 89, 4.2));
        category.addProduct(new Product("Dumbbell", 29, 5.0));
    }

    public static void addProductsOfFood(final Category category) {
        category.addProduct(new Product("Protein", 33, 4.6));
        category.addProduct(new Product("ChocolateBar", 2, 2.3));
        category.addProduct(new Product("Creatine", 28, 4.1));
    }
}

class Basket {
    private Map<Product, String> productsPurchased;

    Basket(Map<Product, String> productsPurchased) {
        this.productsPurchased = productsPurchased;
    }

    public void purchaseProducts(final List<Product> productsCatalogue) {
        for (Product currentProduct : productsCatalogue) {
            productsPurchased.put(currentProduct, dateGenerate());
        }
    }

    public String dateGenerate() {  // чтобы получить разные даты для примера
        ZoneId zone = ZoneId.of("Europe/Minsk");
        LocalDateTime dateExample = LocalDateTime.of(2022, 9, 21, 12, 33);

        DateTimeFormatter dayMonthYearHrsMnSecZone = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss O");
        ZonedDateTime dateTransactionZoned = ZonedDateTime.of(dateExample, zone);

        Random random = new Random();
        int kof = random.nextInt(100_000, 500_000);

        return dayMonthYearHrsMnSecZone.format(dateTransactionZoned.plusSeconds(kof));
    }

    public void getPurchasedProducts() {
        System.out.println("List of purchased products:");

        for (Map.Entry<Product, String> currentProduct : productsPurchased.entrySet()) {
            System.out.println(currentProduct.getKey().getNameProduct()
                    + ", price = " + currentProduct.getKey().getPrice()
                    + " EUR, score of " + currentProduct.getKey().getScore()
                    + ", has been bought on " + currentProduct.getValue());
        }
    }
}

class Category {
    private final String nameCategory;
    private final List<Product> productsCatalogue;

    Category(String nameCategory, List<Product> products) {
        this.nameCategory = nameCategory;
        this.productsCatalogue = products;
    }

    public List<Product> getProductsCatalogue() {
        return productsCatalogue;
    }

    public void addProduct(final Product product) {
        productsCatalogue.add(product);
    }
}

class Product {
    private final String nameProduct;
    private final Integer price;
    private final Double score;

    Product(String name, Integer price, Double score) {
        this.nameProduct = name;
        this.price = price;
        this.score = score;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public Integer getPrice() {
        return price;
    }

    public Double getScore() {
        return score;
    }
}