package Javaproject;
import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String name;
    private int id;
    private double price;

    // Constructor to initialize the product with a name, id, and price
    public Product(String name, int id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    // Getter for product name
    public String getName() {
        return name;
    }

    // Getter for product ID
    public int getId() {
        return id;
    }

    // Setter for product ID
    public void setId(int id) {
        this.id = id;
    }

    // Getter for product price
    public double getPrice() {
        return price;
    }

    // Setter for product price
    public void setPrice(double price) {
        this.price = price;
    }
}

public class ECommerce {
    public static void main(String[] args) {
        // Create an ArrayList to store the available products
        ArrayList<Product> productList = new ArrayList<>();
        // Create an ArrayList to store the products added to the shopping cart
        ArrayList<Product> shoppingCart = new ArrayList<>();
        // Create a Scanner object to read user input from the console
        Scanner inputScanner = new Scanner(System.in);

        // Add some products to the productList
        productList.add(new Product("Gaming Desktop", 1, 1999.99));
        productList.add(new Product("iPhone 14 pro", 2, 899.99));
        productList.add(new Product("IOS Tablet", 3, 349.99));
        productList.add(new Product("Bose Headphones", 4, 79.99));
        productList.add(new Product("Apple Watch", 5, 499.99));
        productList.add(new Product("Xbox series x", 6, 334.99));

        // Set a flag to control the shopping loop
        boolean shopping = true;
        while (shopping) {
            // Display a welcome message and list all available products
            System.out.println("Welcome to our E-Commerce platform! Here are the available products:");
            for (Product product : productList) {
                // Print the ID, name, and price of each product
                System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Price: $" + product.getPrice());
            }

            // Prompt the user to enter the ID of the product they want to add to their cart
            System.out.println("\nEnter the ID of the product you want to add to your cart:");
            int productId = inputScanner.nextInt();

            // Find the product with the given ID and add it to the shopping cart
            boolean productFound = false;
            for (Product product : productList) {
                if (product.getId() == productId) {
                    shoppingCart.add(product);
                    productFound = true;
                    System.out.println(product.getName() + " has been added to your cart.");
                    break;
                }
            }

            // If the product ID is not found, inform the user
            if (!productFound) {
                System.out.println("Product with ID " + productId + " not found.");
            }

            // Ask the user if they want to continue shopping
            System.out.println("Do you want to continue shopping? (yes/no)");
            String continueShopping = inputScanner.next();
            if (!continueShopping.equalsIgnoreCase("yes")) {
                shopping = false;
            }
        }

        // Display the products in the shopping cart
        System.out.println("Here are the products in your cart:");
        for (Product product : shoppingCart) {
            System.out.println("ID: " + product.getId() + ", Name: " + product.getName() + ", Price: $" + product.getPrice());
        }

        // Close the Scanner object
        inputScanner.close();
    }
}