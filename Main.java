import java.time.chrono.ChronoLocalDate;
import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // Create a Customer named John Smith
        Customer customer1 = new Customer("John", "Smith", "2000-10-26",
                "example@gmail.com","123456789","ID123456");

        // Create 5 Products of each type
        Product laptop = new Product("Laptop", "A fast laptop", 90.25, ProductType.ELECTRONIC);
        Product phone = new Product("Phone", "A new smartphone", 200, ProductType.ELECTRONIC);
        Product tablet = new Product("Tablet", "A new Tablet", 330.60, ProductType.ELECTRONIC);
        Product smartwatch = new Product("Smartwatch", "A smartwatch", 120, ProductType.ELECTRONIC);
        Product headphone = new Product("Headphones", "Noise-canceling headphones", 80.25, ProductType.ELECTRONIC);

        Product harryPotter = new Product("Harry Potter", "A popular book", 15.0, ProductType.LIBRARY);
        Product nineteenEightyFour = new Product("1984", "A classic novel", 20.0, ProductType.LIBRARY);
        Product java8 = new Product("Java 8", "A programming book", 52.4, ProductType.LIBRARY);
        Product python101 = new Product("Python 101", "Intro to Python", 30.0, ProductType.LIBRARY);
        Product dataScience = new Product("Data Science", "Data Science book", 110.0, ProductType.LIBRARY);

        Product tshirt = new Product("T-shirt", "A cotton t-shirt", 12.4, ProductType.OTHER);
        Product mug = new Product("Mug", "A coffee mug", 5.0, ProductType.OTHER);
        Product notebook = new Product("Notebook", "A writing notebook", 10.0, ProductType.OTHER);
        Product backpack = new Product("Backpack", "A school backpack", 25.0, ProductType.OTHER);
        Product penSet = new Product("Pen Set", "A set of pens", 18.0, ProductType.OTHER);

        // Create a shopping cart with 4 ELECTRONIC products
        Cart cart1 = new Cart(customer1);
        cart1.productList.add(laptop);
        cart1.productList.add(tablet);
        cart1.productList.add(phone);
        cart1.productList.add(smartwatch);

        //Create a shopping cart with 3 LIBRARY products
        Cart cart2 = new Cart(customer1);
        cart2.productList.add(harryPotter);
        cart2.productList.add(nineteenEightyFour);
        cart2.productList.add(java8);

        //Create a shopping cart with 1 OTHER products
        Cart cart3 = new Cart(customer1);
        cart3.productList.add(tshirt);

        //Submit a Shopping Cart
        cart1.submitCart();

        //A shopping cart with a list of products in different categories (at least 3 for category).
        Cart shoppingCart = new Cart(customer1);
        shoppingCart.productList.add(laptop);
        shoppingCart.productList.add(tablet);
        shoppingCart.productList.add(phone);
        shoppingCart.productList.add(harryPotter);
        shoppingCart.productList.add(java8);
        shoppingCart.productList.add(dataScience);
        shoppingCart.productList.add(tshirt);
        shoppingCart.productList.add(mug);
        shoppingCart.productList.add(notebook);

        //Calculate and Print all products with price > 100 and product type is library
        List<Product> productsGraterThan100 = shoppingCart.productList.stream()
                .filter(p -> p.getPrice() > 100 && p.getType().equals(ProductType.LIBRARY)).toList();

        System.out.println("Products with price > 100 and product type is Library");
        productsGraterThan100.forEach(p ->
                System.out.println(p.getName() + " - $" + p.getPrice()));

        // Calculate and Print sum(price) of all products
        double sumAllProducts = shoppingCart.productList.stream().mapToDouble(Product::getPrice).sum();
        System.out.println("Total Sum of all products: $" + sumAllProducts);

        // Calculate and Print sum(price) of all electronic products
        double sumAllElectronicsProducts = shoppingCart.productList.stream()
                .filter(p -> p.getType().equals(ProductType.ELECTRONIC)).mapToDouble(Product::getPrice).sum();
        System.out.println("Sum of all electronic products: $" + sumAllElectronicsProducts);

        // Print all information of the shopping cart ordered by price
        shoppingCart.getProductList().stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .forEach(product ->
                        System.out.println(shoppingCart.getId() + " | " + product.getId() + " | " + product.getType() + " | " + product.getName() + " | $" + product.getPrice()));

    }
}
