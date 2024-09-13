import java.util.UUID;

public class Product {

    private UUID id;
    private String name;

    private String description;
    private double price;

    private ProductType type;

    public Product(String name, String description, double price, ProductType type) {
        this.id = id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.price = price;
        this.type = type;
    }

    public Product() {
    }

    public UUID getId() {
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }
}
