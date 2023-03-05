package by.teachmeskills.homeworks.hm_10032023.Shop;

import by.teachmeskills.homeworks.hm_10032023.Shop.excepcions.EmptyProductListException;
import by.teachmeskills.homeworks.hm_10032023.Shop.excepcions.EntityAlreadyExistsException;
import by.teachmeskills.homeworks.hm_10032023.Shop.excepcions.EntityNotFoundException;

import java.util.ArrayList;

public class Run {
    public static void main(String[] args) {
        Shop shop = new Shop();

        Product rice = new Product("rice", 3.7);
        Product cupcake = new Product("cupcake", 7);
        Product milk = new Product("milk", 3.7);

        Product[] products = {rice, cupcake, milk};

        for (Product product : products) {
            try {
                shop.addProduct(product);
            } catch (EntityAlreadyExistsException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            ArrayList<Product> productsInShop = shop.getProductsList();
            for (Product product : productsInShop) {
                System.out.println(product.getNAME());
            }
        } catch (EmptyProductListException e) {
            throw new RuntimeException(e);
        }

        try {
            shop.deleteProduct(2);
        } catch (EmptyProductListException | EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("______________________________");
        try {
            ArrayList<Product> productsInShop = shop.getProductsList();
            for (Product product : productsInShop) {
                System.out.println(product.showProductInfo());
            }
        } catch (EmptyProductListException e) {
            throw new RuntimeException(e);
        }

        try {
            shop.editProductPrice(1, 24.3);
        } catch (EmptyProductListException | EntityNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("______________________________");
        try {
            System.out.println(shop.getProductsList().get(1).showProductInfo());
        } catch (EmptyProductListException e) {
            throw new RuntimeException(e);
        }

        try {
            shop.deleteProduct(4);
        } catch (EmptyProductListException | EntityNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
