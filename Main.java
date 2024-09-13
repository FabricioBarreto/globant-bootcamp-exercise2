import java.time.chrono.ChronoLocalDate;
import java.util.*;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // Create a Customer named John Smith
        Customer customer1 = new Customer("John", "Smith", "2000-10-26",
                "example@gmail.com","123456789","ID123456");

        // Create 5 Products of each type
        Product laptop = new Product("Laptop", "A fast laptop", 150.20, ProductType.ELECTRONIC);
        Product phone = new Product("Phone", "A new smartphone", 200, ProductType.ELECTRONIC);
        Product tablet = new Product("Tablet", "A new Tablet", 330.60, ProductType.ELECTRONIC);
        Product smartwatch = new Product("Smartwatch", "A smartwatch", 120, ProductType.ELECTRONIC);
        Product headphone = new Product("Headphones", "Noise-canceling headphones", 80.25, ProductType.ELECTRONIC);

        Product harryPotter = new Product("Harry Potter", "A popular book", 15.0, ProductType.LIBRARY);
        Product nineteenEightyFour = new Product("1984", "A classic novel", 20.0, ProductType.LIBRARY);
        Product java8 = new Product("Java 8", "A programming book", 52.4, ProductType.LIBRARY);
        Product python101 = new Product("Python 101", "Intro to Python", 30.0, ProductType.LIBRARY);
        Product dataScience = new Product("Data Science", "Data Science book", 100.0, ProductType.LIBRARY);

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

    }
}
