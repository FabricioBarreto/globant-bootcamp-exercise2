package service.impl;

import model.Cart;
import model.Customer;
import model.Product;
import model.ShoppingCartItem;
import repository.CartRepository;
import service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {

    CartRepository cartRepository = new CartRepository();

    @Override
    public Cart createCart(Long cartId, Customer customer) {
        List<Cart> carts = cartRepository.getCarts();

        if (carts.stream().anyMatch(cart -> cart.getId().equals(cartId))) {
            throw new RuntimeException(String.format("Cart with id %d already exists", cartId));
        }

        Cart cart = new Cart(cartId,customer);
        carts.add(cart);

        return cart;
    }

    @Override
    public void addShoppingCartItem(Long cartId, Long shoppingCartItemId, Product product, int quantity) {

        Cart cartFound = cartRepository.getCarts().stream()
                .filter(c -> c.getId().equals(cartId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Cart with id %d not found", cartId)));

        cartFound.getItems().add(new ShoppingCartItem(shoppingCartItemId,product,quantity));

    }
}
