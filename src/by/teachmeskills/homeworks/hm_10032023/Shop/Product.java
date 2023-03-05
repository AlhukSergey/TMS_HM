package by.teachmeskills.homeworks.hm_10032023.Shop;

public class Product {
    private static int idInitializer;
    private final int ID;
    private final String NAME;
    private double price;

    public Product(String NAME, double price) {
        this.NAME = NAME;
        this.price = price;
        this.ID = idInitializer++;
    }

    public int getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String showProductInfo() {
        return this.NAME + " " + this.price;
    }
}
