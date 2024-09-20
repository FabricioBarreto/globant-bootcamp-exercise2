package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private Long id;
    private String name;

    private String description;
    private BigDecimal price;

    private ProductType type;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public Product(Long id, String name, String description, BigDecimal price, ProductType type) {
        if(Objects.isNull(id)) throw new IllegalArgumentException("Id cannot be null");
        if(Objects.isNull(name)) throw new IllegalArgumentException("Name cannot be null");
        if(Objects.isNull(description)) throw new IllegalArgumentException("Description cannot be null");
        if(Objects.isNull(price)) throw new IllegalArgumentException("Price cannot be null");
        if(price.compareTo(BigDecimal.ZERO) <= 0) throw new IllegalArgumentException("Price must be greater than zero");
        if(Objects.isNull(type)) throw new IllegalArgumentException("Type cannot be null");
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return Objects.equals(getId(), product.getId()) && Objects.equals(getName(), product.getName()) && Objects.equals(getDescription(), product.getDescription()) && Objects.equals(getPrice(), product.getPrice()) && getType() == product.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPrice(), getType());
    }
}
