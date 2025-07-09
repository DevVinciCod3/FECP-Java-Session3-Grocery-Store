package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        InventorySystem store = new InventorySystem();

        Scanner s = new Scanner(System.in);

        boolean looper = true;

        while (looper) {
            System.out.println("\n--- Grocery Inventory System ---");
            System.out.println("1. View Inventory");
            System.out.println("2. Add Product");
            System.out.println("3. Check Product");
            System.out.println("4. Update Stock");
            System.out.println("5. Remove Product");
            System.out.println("6. Exit");
            System.out.print("Choose Option: ");
            int choice = s.nextInt();
            s.nextLine(); // consume newline

            switch (choice) {
                case 1: {
                    store.viewInventory();
                    break;
                }

                case 2: {
                    System.out.print("Product Name: ");
                    String productName = s.nextLine();

                    System.out.print("Quantity: ");
                    int quantity = s.nextInt();

                    store.addProduct(productName, quantity);

                    break;
                }
                case 3: {
                    System.out.print("Enter Product Name to Check : ");
                    String productName = s.nextLine();
                    ;
                    store.checkProduct(productName);

                    break;
                }
                case 4: {
                    System.out.print("Enter Product Name to Update : ");
                    String productName = s.nextLine();

                    System.out.print("Quantity: ");
                    int quantity = s.nextInt();

                    store.updateProduct(productName, quantity);

                    break;
                }

                case 5: {
                    System.out.print("Enter order number to remove: ");
                    String productName = s.nextLine();

                    store.removeProduct(productName);

                    break;
                }

                case 6: {
                    looper = false;
                    System.out.println("Exiting system ....");
                    break;
                }

                default: {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
