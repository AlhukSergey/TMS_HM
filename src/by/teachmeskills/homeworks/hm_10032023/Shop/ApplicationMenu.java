package by.teachmeskills.homeworks.hm_10032023.Shop;

import by.teachmeskills.homeworks.hm_10032023.Shop.exceptions.EmptyProductListException;
import by.teachmeskills.homeworks.hm_10032023.Shop.exceptions.EntityAlreadyExistsException;
import by.teachmeskills.homeworks.hm_10032023.Shop.exceptions.EntityNotFoundException;

import java.util.Scanner;

public class ApplicationMenu {
    public void start(Shop shop) {
        System.out.println("What do you want to do?");
        System.out.println("1. Output of all products.");
        System.out.println("2. Add a product.");
        System.out.println("3. Delete a product.");
        System.out.println("4. Edit a product.");
        System.out.println("5. Exit.");
        System.out.println("Please, enter the number of the action:");

        try (Scanner sc = new Scanner(System.in)) {
            boolean flag = true;
            int userChoice = Integer.parseInt(sc.next());
            while (flag) {
                if (userChoice < 1 || userChoice > 5) {
                    System.out.println("You have to enter a number from 1 to 5. Please enter the number: ");
                    userChoice = Integer.parseInt(sc.next());
                } else {
                    switch (userChoice) {
                        case 1 -> showProducts(sc, shop);
                        case 2 -> addProduct(sc, shop);
                        case 3 -> deleteProduct(sc, shop);
                        case 4 -> editProduct(sc, shop);
                        case 5 -> System.out.println("Bye-bye!");
                    }
                    flag = false;
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void showProducts(Scanner sc, Shop shop) {
        int userChoice;
        System.out.println("In what sort do you want to see the list of products?");
        System.out.println("1. By price(asc).");
        System.out.println("2. By price(desc).");
        System.out.println("Please, enter the number of the action:");
        try {
            userChoice = Integer.parseInt(sc.next());
            boolean flagInFirstBlock = true;
            while (flagInFirstBlock) {
                if (userChoice < 1 || userChoice > 2) {
                    System.out.println("Invalid data entered. Enter a number from 1 or 2, please..");
                } else {
                    switch (userChoice) {
                        case 1 -> shop.showProductsList(shop.sortByPrice(shop.getProductsList()));
                        case 2 -> shop.showReversedProductsList(shop.sortByPrice(shop.getProductsList()));
                    }
                    flagInFirstBlock = false;
                }
            }
        } catch (IllegalArgumentException | EmptyProductListException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addProduct(Scanner sc, Shop shop) {
        System.out.println("Please, enter separated by commas: id of the product, it's name, and it's price: ");
        String[] parameters = sc.next().split(",");
        Product product = new Product(Integer.parseInt(parameters[0]), parameters[1], Double.parseDouble(parameters[2]));
        try {
            shop.addProduct(product);
            System.out.println("The product \"" + product.getName() + "\" successful added!");
        } catch (EntityAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    private void deleteProduct(Scanner sc, Shop shop) {
        System.out.println("Please, enter id of the product, what do you want do delete:");
        int productId = sc.nextInt();
        try {
            shop.deleteProduct(productId);
            System.out.println("The product with id \"" + productId + "\" successful deleted!");
        } catch (EntityNotFoundException | EmptyProductListException e) {
            System.out.println(e.getMessage());
        }
    }

    private void editProduct(Scanner sc, Shop shop) {
        System.out.println("Please, enter separated by commas: id of the product, which do you want to edit, " +
                "it's new name, and it's new price: ");
        String[] parameters = sc.next().split(",");
        try {
            shop.editProductName(Integer.parseInt(parameters[0]), parameters[1]);
            System.out.println("The name of the product with id \"" + Integer.parseInt(parameters[0]) + "\" successful changed!");
            shop.editProductPrice(Integer.parseInt(parameters[0]), Double.parseDouble(parameters[2]));
            System.out.println("The price of the product with id \"" + Integer.parseInt(parameters[0]) + "\" successful changed!");
        } catch (EntityNotFoundException | EmptyProductListException e) {
            System.out.println(e.getMessage());
        }
    }
}
