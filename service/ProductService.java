package service;

import model.Cart;
import model.Product;
import model.ProductType;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    Product createProduct(Long id, String name, String description, BigDecimal price, ProductType type);

    List<Product> productsPriceGraterThan100AndTypeLibrary(Cart cart);

    BigDecimal sumPriceOfAllProducts(Cart shoppingCart);

    BigDecimal sumPriceOfAllElectronic(Cart shoppingCart);

    StringBuilder informationOrderedByPrice(Cart shoppingCart);
}
