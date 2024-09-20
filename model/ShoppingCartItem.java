package model;

import java.math.BigDecimal;
import java.util.Objects;

public class ShoppingCartItem {

    private Long id;
    private Product product;

    private int quantity;

    public Long getId() {
        return id;
    }

    public BigDecimal getTotal(){
        return product.getPrice().multiply(new BigDecimal(quantity));
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public ShoppingCartItem(Long id, Product product, int quantity) {
        if(Objects.isNull(id)) throw new IllegalArgumentException("Id cannot be null");
        if(Objects.isNull(product)) throw new IllegalArgumentException("Product cannot be null");
        if(Objects.isNull(quantity)) throw new IllegalArgumentException("Quantity cannot be null");
        if(quantity <= 0) throw new IllegalArgumentException("Quantity must be greater than zero");
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShoppingCartItem that)) return false;
        return getQuantity() == that.getQuantity() && Objects.equals(getId(), that.getId()) && Objects.equals(getProduct(), that.getProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProduct(), getQuantity());
    }

}
