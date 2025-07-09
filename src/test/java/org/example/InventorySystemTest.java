package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static org.example.InventorySystem.getInventory;
import static org.junit.jupiter.api.Assertions.*;

class InventorySystemTest {

    private InventorySystem system;

    @BeforeEach
    void setUp() throws Exception {
        // Use reflection to reset the static inventory map before each test
        Field inventoryField = InventorySystem.class.getDeclaredField("inventory");
        inventoryField.setAccessible(true);
        inventoryField.set(null, new HashMap<>()); // reset the static map

        system = new InventorySystem();
    }

    @Test
    void testAddProductValidQuantity() {
        system.addProduct("Banana" , 30);
        Map<String, Integer> inventory = getInventory();
        assertTrue(inventory.containsKey("banana"));
        assertEquals(30, inventory.get("banana"));
    }

    @Test
    void testAddProductInvalidQuantityZero() {
        system.addProduct("Mango" , 0);
        Map<String, Integer> inventory = getInventory();
        assertFalse(inventory.containsKey("Mango"));
    }

    @Test
    void testAddProductExisting() {
        system.addProduct("Milk" , 50);
        Map<String, Integer> inventory = getInventory();
        assertTrue(inventory.containsKey("milk"));
        assertEquals(60, inventory.get("milk"));
    }

    @Test
    void testAddProductInvalidQuantityNegative() {
        system.addProduct("Chicharon" , -5);
        Map<String, Integer> inventory = getInventory();
        assertFalse(inventory.containsKey("chicharon"));
    }



    @Test
    void testCheckProduct() {
        system.checkProduct("Milk");
        Map<String, Integer> inventory = getInventory();
        assertTrue(inventory.containsKey("milk"));
        assertEquals(10, inventory.get("milk"));
    }

    @Test
    void testCheckProductNotExisting() {
        system.checkProduct("Ice cream");
        Map<String, Integer> inventory = getInventory();
        assertFalse(inventory.containsKey("ice cream"));
    }

    @Test
    void testUpdateProductValid() {
        system.updateProduct("Bread" , 5);
        Map<String, Integer> inventory = getInventory();
        assertEquals(25, inventory.get("bread"));
    }

    @Test
    void testUpdateProductInvalid() {
        system.updateProduct("Tofu" , 5);
        Map<String, Integer> inventory = getInventory();
        assertFalse(inventory.containsKey("tofu"));
    }

    @Test
    void testRemoveProductValid() {
        system.removeProduct("Eggs");
        Map<String, Integer> inventory = getInventory();
        assertFalse(inventory.containsKey("eggs"));
    }

    @Test
    void testRemoveProductInvalid() {
        system.removeProduct("Pizza");
        Map<String, Integer> inventory = getInventory();
        assertFalse(inventory.containsKey("pizza"));
    }

}