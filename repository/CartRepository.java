package repository;

import model.Cart;

import java.util.ArrayList;
import java.util.List;

public class CartRepository {

    List<Cart> carts = new ArrayList<>();

    public List<Cart> getCarts() {
        return carts;
    }
}
