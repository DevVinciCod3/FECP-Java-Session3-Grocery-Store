package org.example;

import java.util.*;
public class InventorySystem {

    private static Map<String, Integer> inventory = new HashMap<>();

    public InventorySystem() {
        inventory.put("milk", 10);
        inventory.put("bread", 20);
        inventory.put("eggs", 30);
    }


    public void addProduct( String productName, int quantity) {
        productName = productName.toLowerCase();
        if (inventory.containsKey(productName)) {
            System.out.println(productName + " already exists. Updating quantity.");
            inventory.put(productName, inventory.get(productName) + quantity);
        } else {
            inventory.put(productName, quantity);
            System.out.println(productName + " added with quantity " + quantity);
        }
    }

    public void checkProduct(String productName){
        productName = productName.toLowerCase();
        if (inventory.containsKey(productName.toLowerCase())) {
            System.out.println("Product Name: " + productName);
            System.out.println("Quantity: " + inventory.get(productName));
        }
        else {
            System.out.println(productName + " is not in inventory.");
        }

    }

    public void updateProduct(String productName, int quantityChange) {
        productName = productName.toLowerCase();
        if (inventory.containsKey(productName)) {
            int newQuantity = inventory.get(productName) + quantityChange;
            inventory.put(productName, newQuantity);
            System.out.println(productName + " updated. New quantity: " + newQuantity);

        } else {
            System.out.println(productName + " not found in inventory.");
        }
    }

    public void removeProduct(String productName) {
        productName = productName.toLowerCase();
        if (inventory.containsKey(productName)) {
            inventory.remove(productName);
            System.out.println(productName + " removed from inventory.");
        } else {
            System.out.println(productName + " not found.");
        }
    }


    public void viewInventory() {
        System.out.println("Current Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }




}
