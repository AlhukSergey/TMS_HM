package by.teachmeskills.homeworks.hm_10032023.Shop;

import by.teachmeskills.homeworks.hm_10032023.Shop.excepcions.EmptyProductListException;
import by.teachmeskills.homeworks.hm_10032023.Shop.excepcions.EntityAlreadyExistsException;
import by.teachmeskills.homeworks.hm_10032023.Shop.excepcions.EntityNotFoundException;

import java.util.ArrayList;

public class Shop {
    private final ArrayList<Product> productsList = new ArrayList<>();

    public void addProduct(Product product) throws EntityAlreadyExistsException {
        boolean flag = false;
        for (Product value : productsList) {
            if (value.getID() == product.getID()) {
                flag = true;
                break;
            }
        }
        if (flag) {
            throw new EntityAlreadyExistsException("The product exists.");
        } else {
            this.productsList.add(product);
        }
    }

    public ArrayList<Product> getProductsList() throws EmptyProductListException {
        if (this.productsList.isEmpty()) {
            throw new EmptyProductListException("No products found.");
        } else {
            return productsList;
        }
    }

    public void deleteProduct(int id) throws EmptyProductListException, EntityNotFoundException {
        if (this.productsList.isEmpty()) {
            throw new EmptyProductListException("No products found.");
        } else {
            boolean flag = false;
            for (int i = 0; i < productsList.size(); i++) {
                if (productsList.get(i).getID() == id) {
                    flag = true;
                    productsList.remove(i);
                    break;
                }
            }
            if (flag == false) {
                throw new EntityNotFoundException("Product with " + id + " not found.");
            }
        }
    }

    public void editProductPrice(int id, double newPrice) throws EmptyProductListException, EntityNotFoundException {
        if (this.productsList.isEmpty()) {
            throw new EmptyProductListException("No products found.");
        } else {
            boolean flag = false;
            for (Product product : productsList) {
                if (product.getID() == id) {
                    flag = true;
                    product.setPrice(newPrice);
                    break;
                }
            }
            if (flag == false) {
                throw new EntityNotFoundException("Product with " + id + " not found.");
            }
        }
    }

    public ArrayList<Product> sortByPrice(ArrayList<Product> productsList) {
        ArrayList<Product> products = (ArrayList<Product>)productsList.clone();
        for (int i = 1; i < productsList.size(); i++) {
            if (productsList.get(i).getPrice() < productsList.get(i - 1).getPrice()) {
                Product temp = productsList.get(i);
                productsList.set(i, productsList.get(i - 1));
                productsList.set(i - 1, temp);
            }
        }
        return products;
    }
}
