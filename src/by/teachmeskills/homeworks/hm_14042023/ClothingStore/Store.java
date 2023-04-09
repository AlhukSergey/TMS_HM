package by.teachmeskills.homeworks.hm_14042023.ClothingStore;

import by.teachmeskills.homeworks.hm_14042023.ClothingStore.exceptions.EmptyProductListException;
import by.teachmeskills.homeworks.hm_14042023.ClothingStore.exceptions.EntityNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private String name;
    private List<Product> productsList = new ArrayList<>();

    public Store(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProductsList() throws EmptyProductListException {
        if (productsList.isEmpty()) {
            throw new EmptyProductListException("The store hasn't received the products yet.");
        } else {
            return productsList;
        }
    }

    public String getProductsListAsString() {
        StringBuilder line = new StringBuilder();
        for (Product product : productsList) {
            line.append(product.getName()).append(" ");
        }
        return line.toString();
    }

    public void addProduct(Product product) {
        this.productsList.add(product);
    }

    public void deleteProduct(String name) throws EmptyProductListException, EntityNotFoundException {
        if (productsList.isEmpty()) {
            throw new EmptyProductListException("The store hasn't received the products yet.");
        } else {
            for (Product product : productsList) {
                if (product.getName().equalsIgnoreCase(name)) {
                    productsList.remove(product);
                } else {
                    throw new EntityNotFoundException("There is no such product in our store!");
                }
            }
        }
    }
}
