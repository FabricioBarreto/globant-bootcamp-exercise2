import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static List<Product> productsPriceGraterThan100AndTypeLibrary(Cart cart){
        return cart.items.stream()
                .filter(i -> i.getTotal().compareTo(new BigDecimal("100")) > 0
                        && i.getProduct().getType().equals(ProductType.LIBRARY))
                .map(ShoppingCartItem::getProduct)
                .collect(Collectors.toList());
    }

    public static BigDecimal sumPriceOfAllProducts(Cart shoppingCart) {
        return shoppingCart.items.stream()
                .map(ShoppingCartItem::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static BigDecimal sumPriceOfAllElectronic(Cart shoppingCart) {
        return shoppingCart.items.stream()
                .filter(i -> i.getProduct().getType().equals(ProductType.ELECTRONIC))
                .map(ShoppingCartItem::getTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public static StringBuilder informationOrderedByPrice(Cart shoppingCart){
        StringBuilder result = new StringBuilder();

        result.append("Cart ID | ID | PRODUCT TYPE | PRODUCT NAME | PRICE\n");

        shoppingCart.getItems().stream()
                .sorted(Comparator.comparing(i -> i.getProduct().getPrice()))
                .forEach(i ->
                        result.append(shoppingCart.getId())
                                .append(" | ")
                                .append(i.getProduct().getId())
                                .append(" | ")
                                .append((i.getProduct().getType().value))
                                .append(" | ")
                                .append(i.getProduct().getName())
                                .append(" | ")
                                .append(i.getTotal())
                                .append("\n")
                );

        return new StringBuilder(result.toString());
    }

    public static void main(String[] args) {

        // Create a Customer named John Smith
        Customer customer1 = new Customer(1L, "John", "Smith", "2000-10-26",
                "example@gmail.com","123456789");

        // Create 5 Products of each type
        Product laptop = new Product(1L, "Laptop", "A fast laptop", new BigDecimal("90.25"), ProductType.ELECTRONIC);
        Product phone = new Product(2L, "Phone", "A new smartphone",  new BigDecimal("200"), ProductType.ELECTRONIC);
        Product tablet = new Product(3L, "Tablet", "A new Tablet", new BigDecimal("330.60"), ProductType.ELECTRONIC);
        Product smartwatch = new Product(4L,"Smartwatch", "A smartwatch", new BigDecimal("120"), ProductType.ELECTRONIC);
        Product headphone = new Product(5L,"Headphones", "Noise-canceling headphones", new BigDecimal("80.25"), ProductType.ELECTRONIC);

        Product harryPotter = new Product(6L,"Harry Potter", "A popular book", new BigDecimal("15.0"), ProductType.LIBRARY);
        Product nineteenEightyFour = new Product(7L,"1984", "A classic novel", new BigDecimal("20.0"), ProductType.LIBRARY);
        Product java8 = new Product(8L,"Java 8", "A programming book", new BigDecimal("52.4"), ProductType.LIBRARY);
        Product python101 = new Product(9L,"Python 101", "Intro to Python", new BigDecimal("30.0"), ProductType.LIBRARY);
        Product dataScience = new Product(10L,"Data Science", "Data Science book", new BigDecimal("110.0"), ProductType.LIBRARY);

        Product tshirt = new Product(11L,"T-shirt", "A cotton t-shirt", new BigDecimal("12.4"), ProductType.OTHER);
        Product mug = new Product(12L,"Mug", "A coffee mug", new BigDecimal("5.0"), ProductType.OTHER);
        Product notebook = new Product(13L,"Notebook", "A writing notebook", new BigDecimal("10.0"), ProductType.OTHER);
        Product backpack = new Product(14L,"Backpack", "A school backpack", new BigDecimal("25.0"), ProductType.OTHER);
        Product penSet = new Product(15L,"Pen Set", "A set of pens", new BigDecimal("18.0"), ProductType.OTHER);

        // Create a shopping cart with 4 ELECTRONIC products
        Cart cart1 = new Cart(1L, customer1);
        cart1.items.add(new ShoppingCartItem(1L,laptop,2));
        cart1.items.add(new ShoppingCartItem(2L,tablet,1));
        cart1.items.add(new ShoppingCartItem(3L,phone,4));
        cart1.items.add(new ShoppingCartItem(4L,smartwatch,3));

        //Create a shopping cart with 3 LIBRARY products
        Cart cart2 = new Cart(2L,customer1);
        cart2.items.add(new ShoppingCartItem(1L,harryPotter,2));
        cart2.items.add(new ShoppingCartItem(2L,nineteenEightyFour,4));
        cart2.items.add(new ShoppingCartItem(3L,java8,3));

        //Create a shopping cart with 1 OTHER products
        Cart cart3 = new Cart(3L,customer1);
        cart3.items.add(new ShoppingCartItem(1L,tshirt,2));

        //Submit a Shopping Cart
        cart1.submitCart();

        //A shopping cart with a list of products in different categories (at least 3 for category).
        Cart shoppingCart = new Cart(4L,customer1);
        shoppingCart.items.add(new ShoppingCartItem(1L,laptop,3));
        shoppingCart.items.add(new ShoppingCartItem(2L,tablet,2));
        shoppingCart.items.add(new ShoppingCartItem(3L,phone,5));
        shoppingCart.items.add(new ShoppingCartItem(4L,harryPotter,1));
        shoppingCart.items.add(new ShoppingCartItem(5L,java8,2));
        shoppingCart.items.add(new ShoppingCartItem(6L,dataScience,4));
        shoppingCart.items.add(new ShoppingCartItem(7L,tshirt,2));
        shoppingCart.items.add(new ShoppingCartItem(8L,mug,4));
        shoppingCart.items.add(new ShoppingCartItem(9L,notebook,1));

        //Calculate and Print all products with price > 100 and product type is library
        System.out.println(productsPriceGraterThan100AndTypeLibrary(shoppingCart));

        // Calculate and Print sum(price) of all products
        System.out.println(sumPriceOfAllProducts(shoppingCart));

        // Calculate and Print sum(price) of all electronic products
        System.out.println(sumPriceOfAllElectronic(shoppingCart));

        // Print all information of the shopping cart ordered by price
        System.out.println(informationOrderedByPrice(shoppingCart));

    }
}
