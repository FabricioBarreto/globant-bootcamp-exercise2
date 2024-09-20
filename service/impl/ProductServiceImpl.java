package service.impl;

import model.*;
import repository.ProductRepository;
import service.ProductService;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository = new ProductRepository();

    @Override
    public Product createProduct(Long id, String name, String description, BigDecimal price, ProductType type) {
        List<Product> products = productRepository.getProducts();

        if (products.stream().anyMatch(customer -> customer.getId().equals(id))) {
            throw new RuntimeException(String.format("Product with id %d already exists", id));
        }

        Product product = new Product(id, name, description, price, type);
        products.add(product);

        return product;

    }

    @Override
    public List<Product> productsPriceGraterThan100AndTypeLibrary(Cart cart){
        return cart.getItems().stream()
                .filter(i -> i.getTotal().compareTo(new BigDecimal("100")) > 0
                        && i.getProduct().getType().equals(ProductType.LIBRARY))
                .map(ShoppingCartItem::getProduct)
                .collect(Collectors.toList());
    }

    @Override
    public BigDecimal sumPriceOfAllProducts(Cart shoppingCart) {
        return shoppingCart.getItems().stream()
                .map(ShoppingCartItem::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public BigDecimal sumPriceOfAllElectronic(Cart shoppingCart) {
        return shoppingCart.getItems().stream()
                .filter(i -> i.getProduct().getType().equals(ProductType.ELECTRONIC))
                .map(ShoppingCartItem::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public StringBuilder informationOrderedByPrice(Cart shoppingCart){
        StringBuilder result = new StringBuilder();

        // Definir los encabezados con un formato de columnas adecuado
        result.append(String.format("%-8s | %-3s | %-12s | %-20s | %-10s\n", "Cart ID", "ID", "PRODUCT TYPE", "PRODUCT NAME", "PRICE"));

        // Ordenar y formatear cada fila
        shoppingCart.getItems().stream()
                .sorted(Comparator.comparing(i -> i.getProduct().getPrice()))
                .forEach(i -> result.append(String.format("%-8d | %-3d | %-12s | %-20s | %-10.2f\n",
                        shoppingCart.getId(),
                        i.getProduct().getId(),
                        i.getProduct().getType(),
                        i.getProduct().getName(),
                        i.getTotal())));

        return new StringBuilder(result.toString());
    }

}
