package by.teachmeskills.homeworks.hm_10032023.Shop;

import by.teachmeskills.homeworks.hm_10032023.Shop.exceptions.EmptyProductListException;
import by.teachmeskills.homeworks.hm_10032023.Shop.exceptions.EntityAlreadyExistsException;
import by.teachmeskills.homeworks.hm_10032023.Shop.exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shop {
    private List<Product> productsList = new ArrayList<>();

    public void addProduct(Product product) throws EntityAlreadyExistsException {
        for (Product value : productsList) {
            if (value.getId() == product.getId()) {
                throw new EntityAlreadyExistsException("The product with " + product.getId() + "already exists.");
            }
        }
        this.productsList.add(product);
    }

    public List<Product> getProductsList() throws EmptyProductListException {
        if (this.productsList.isEmpty()) {
            throw new EmptyProductListException("No products found.");
        } else {
            return productsList;
        }
    }

    public void deleteProduct(int id) throws EmptyProductListException, EntityNotFoundException {
        if (this.productsList.isEmpty()) {
            throw new EmptyProductListException("No products found.");
        } else if (containsProduct(productsList, id)) {
            for (Product product : productsList) {
                if (product.getId() == id) {
                    productsList.remove(product);
                    break;
                }
            }
        } else {
            throw new EntityNotFoundException("Product with " + id + " not found.");
        }
    }

    public void editProductPrice(int id, double newPrice) throws EmptyProductListException, EntityNotFoundException {
        if (productsList.isEmpty()) {
            throw new EmptyProductListException("No products found.");
        } else if (containsProduct(productsList, id)) {
            for (Product product : productsList) {
                if (product.getId() == id) {
                    product.setPrice(newPrice);
                    break;
                }
            }
        } else {
            throw new EntityNotFoundException("Product with " + id + " not found.");
        }
    }

    public void editProductName(int id, String name) throws EmptyProductListException, EntityNotFoundException {
        if (productsList.isEmpty()) {
            throw new EmptyProductListException("No products found.");
        } else if (containsProduct(productsList, id)) {
            for (Product product : productsList) {
                if (product.getId() == id) {
                    product.setName(name);
                    break;
                }
            }
        } else {
            throw new EntityNotFoundException("Product with " + id + " not found.");
        }
    }

    public List<Product> sortByPrice(List<Product> productsList) {
        productsList.sort((o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
        return productsList;
    }

    public void showProductsList(List<Product> list) {
        for (Product product : list) {
            System.out.println(product.getName());
        }
    }

    public void showReversedProductsList(List<Product> list) {
        Collections.reverse(list);
        for (Product product : list) {
            System.out.println(product.getName());
        }
    }

    private boolean containsProduct(List<Product> productsList, int id) {
        boolean contains = false;
        for (Product p : productsList) {
            if (p.getId() == id) {
                contains = true;
                break;
            }
        }
        return contains;
    }
}
