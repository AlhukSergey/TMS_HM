package by.teachmeskills.homeworks.hm_10032023.Shop;

import by.teachmeskills.homeworks.hm_10032023.Shop.exceptions.EmptyProductListException;
import by.teachmeskills.homeworks.hm_10032023.Shop.exceptions.EntityAlreadyExistsException;
import by.teachmeskills.homeworks.hm_10032023.Shop.exceptions.EntityNotFoundException;

import java.util.List;

public class Run {
    public static void main(String[] args) {
        Shop shop = new Shop();

        Product rice = new Product("rice", 10);
        Product cupcake = new Product("cupcake", 7);
        Product milk = new Product("milk", 7);

        Product[] products = {rice, cupcake, milk};

        for (Product product : products) {
            try {
                shop.addProduct(product);
            } catch (EntityAlreadyExistsException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            List<Product> productsInShop = shop.getProductsList();
            List<Product> sortedProductsInShopList = shop.sortByPrice(productsInShop);
            for (Product product : sortedProductsInShopList) {
                System.out.println(product.getName());
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
            List<Product> productsInShop = shop.getProductsList();
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
            shop.deleteProduct(5);
        } catch (EmptyProductListException | EntityNotFoundException e) {
            throw new RuntimeException(e);
        }

        Shop shop2 = new Shop();

        Product iceCream = new Product(1, "Ice cream", 8.3);
        Product chocolate = new Product(2, "Chocolate", 3.1);
        Product banana = new Product(3, "Banana", 10.0);

        Product[] products2 = {iceCream, chocolate, banana};

        for (Product product : products2) {
            try {
                shop2.addProduct(product);
            } catch (EntityAlreadyExistsException e) {
                System.out.println(e.getMessage());
            }
        }

        ApplicationMenu applicationMenu = new ApplicationMenu();
        applicationMenu.start(shop2);
    }
}
