package service;

import model.Cart;
import model.Customer;
import model.Product;

public interface CartService {

    Cart createCart(Long cartId, Customer customer);

    void addShoppingCartItem(Long cartId, Long shoppingCartItemId, Product product, int quantity);

}
