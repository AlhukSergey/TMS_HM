package by.teachmeskills.homeworks.hm_10032023.Shop;

public class Product {
    private static int idInitializer;
    private int id;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.id = idInitializer++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String showProductInfo() {
        return this.name + " " + this.price;
    }
}
