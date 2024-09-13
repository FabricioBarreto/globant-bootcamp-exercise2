import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Cart {
    private UUID id;

    private CartStatus status;

    List<Product> productList;

    private Customer customer;

    public void submitCart(){
        this.setStatus(CartStatus.SUBMITTED);
    }

    public Cart(Customer customer){
        this.id = UUID.randomUUID();
        this.status = CartStatus.DRAFT;
        this.productList = new ArrayList<>();
        this.customer = customer;
    }

    public UUID getId() {
        return id;
    }

    public CartStatus getStatus() {
        return status;
    }

    public void setStatus(CartStatus status) {
        this.status = status;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
