package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }
}
