import model.Cart;
import model.Product;
import model.Customer;
import model.ProductType;
import service.CartService;
import service.CustomerService;
import service.ProductService;
import service.impl.CartServiceImpl;
import service.impl.CustomerServiceImpl;
import service.impl.ProductServiceImpl;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        ProductService productService = new ProductServiceImpl();
        CustomerService customerService = new CustomerServiceImpl();
        CartService cartService = new CartServiceImpl();

        // Create a Customer named John Smith
        customerService.createCustomer(1L, "John", "Smith", "2000-10-26",
                "example@gmail.com","123456789");

        Customer customer1 = customerService.getCustomerById(1L);

        // Create 5 Products of each type
        Product laptop = productService.createProduct(1L, "Laptop", "A fast laptop", new BigDecimal("90.25"), ProductType.ELECTRONIC);
        Product phone = productService.createProduct(2L, "Phone", "A new smartphone",  new BigDecimal("200"), ProductType.ELECTRONIC);
        Product tablet = productService.createProduct(3L, "Tablet", "A new Tablet", new BigDecimal("330.60"), ProductType.ELECTRONIC);
        Product smartwatch = productService.createProduct(4L,"Smartwatch", "A smartwatch", new BigDecimal("120"), ProductType.ELECTRONIC);
        Product headphones = productService.createProduct(5L,"Headphones", "Noise-canceling headphones", new BigDecimal("80.25"), ProductType.ELECTRONIC);

        Product harryPotter = productService.createProduct(6L,"Harry Potter", "A popular book", new BigDecimal("15.0"), ProductType.LIBRARY);
        Product nineteenEightyFour = productService.createProduct(7L,"1984", "A classic novel", new BigDecimal("20.0"), ProductType.LIBRARY);
        Product java8 = productService.createProduct(8L,"Java 8", "A programming book", new BigDecimal("52.4"), ProductType.LIBRARY);
        Product python = productService.createProduct(9L,"Python 101", "Intro to Python", new BigDecimal("30.0"), ProductType.LIBRARY);
        Product dataScience = productService.createProduct(10L,"Data Science", "Data Science book", new BigDecimal("110.0"), ProductType.LIBRARY);

        Product tshirt = productService.createProduct(11L,"T-shirt", "A cotton t-shirt", new BigDecimal("12.4"), ProductType.OTHER);
        Product mug = productService.createProduct(12L,"Mug", "A coffee mug", new BigDecimal("5.0"), ProductType.OTHER);
        Product notebook = productService.createProduct(13L,"Notebook", "A writing notebook", new BigDecimal("10.0"), ProductType.OTHER);
        Product backpack = productService.createProduct(14L,"Backpack", "A school backpack", new BigDecimal("25.0"), ProductType.OTHER);
        Product penSet = productService.createProduct(15L,"Pen Set", "A set of pens", new BigDecimal("18.0"), ProductType.OTHER);

        // Create a shopping cart with 4 ELECTRONIC products
        Cart cart1 =  cartService.createCart(1L, customer1);
        cartService.addShoppingCartItem(cart1.getId(),1L,laptop,2);
        cartService.addShoppingCartItem(cart1.getId(),2L,tablet,1);
        cartService.addShoppingCartItem(cart1.getId(),3L,phone,4);
        cartService.addShoppingCartItem(cart1.getId(),4L,smartwatch,3);

        //Create a shopping cart with 3 LIBRARY products
        Cart cart2 = cartService.createCart(2L,customer1);
        cartService.addShoppingCartItem(cart2.getId(),1L,harryPotter,2);
        cartService.addShoppingCartItem(cart2.getId(),2L,nineteenEightyFour,4);
        cartService.addShoppingCartItem(cart2.getId(),3L,java8,3);

        //Create a shopping cart with 1 OTHER products
        Cart cart3 = cartService.createCart(3L,customer1);
        cartService.addShoppingCartItem(cart3.getId(),1L,tshirt,2);

        //Submit a Shopping Cart
        cart1.submitCart();

        //A shopping cart with a list of products in different categories (at least 3 for category).
        Cart shoppingCart = cartService.createCart(4L,customer1);
        cartService.addShoppingCartItem(shoppingCart.getId(),1L,laptop,3);
        cartService.addShoppingCartItem(shoppingCart.getId(),2L,tablet,2);
        cartService.addShoppingCartItem(shoppingCart.getId(),3L,phone,5);
        cartService.addShoppingCartItem(shoppingCart.getId(),4L,harryPotter,1);
        cartService.addShoppingCartItem(shoppingCart.getId(),5L,java8,2);
        cartService.addShoppingCartItem(shoppingCart.getId(),6L,dataScience,4);
        cartService.addShoppingCartItem(shoppingCart.getId(),7L,tshirt,2);
        cartService.addShoppingCartItem(shoppingCart.getId(),8L,mug,4);
        cartService.addShoppingCartItem(shoppingCart.getId(),9L,notebook,1);

        //Calculate and Print all products with price > 100 and product type is library
        System.out.println(productService.productsPriceGraterThan100AndTypeLibrary(shoppingCart));

        // Calculate and Print sum(price) of all products
        System.out.println(productService.sumPriceOfAllProducts(shoppingCart));

        // Calculate and Print sum(price) of all electronic products
        System.out.println(productService.sumPriceOfAllElectronic(shoppingCart));

        // Print all information of the shopping cart ordered by price
        System.out.println(productService.informationOrderedByPrice(shoppingCart));

    }
}
