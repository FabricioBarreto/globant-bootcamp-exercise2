package model;

import model.CartStatus;
import model.ShoppingCartItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Cart {
    private Long id;
    private Customer customer;

    private CartStatus status;

    List<ShoppingCartItem> items;

    public void submitCart(){
        this.setStatus(CartStatus.SUBMITTED);
    }

    public void setStatus(CartStatus status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public CartStatus getStatus() {
        return status;
    }

    public List<ShoppingCartItem> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Cart(Long id, Customer customer){
        if(Objects.isNull(id)) throw new IllegalArgumentException("Id cannot be null");
        if(Objects.isNull(customer)) throw new IllegalArgumentException("Customer cannot be null");
        this.id = id;
        this.customer = customer;
        this.status = CartStatus.DRAFT;
        this.items = Objects.isNull(items) ? new ArrayList<>() : items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cart cart)) return false;
        return Objects.equals(getId(), cart.getId()) && getStatus() == cart.getStatus() && Objects.equals(items, cart.items) && Objects.equals(getCustomer(), cart.getCustomer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStatus(), items, getCustomer());
    }
}
