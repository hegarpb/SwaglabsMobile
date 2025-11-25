package com.swaglabs.mobile.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.mobile.driver.DriverManager;
import com.swaglabs.mobile.screens.InventoryScreen;
import com.swaglabs.mobile.screens.LoginScreen;

public class AddToCartTest {
    @Test
    public void addMultipleProductsTest() {
        LoginScreen loginScreen = new LoginScreen(DriverManager.getDriver());
        InventoryScreen inventory = new InventoryScreen(DriverManager.getDriver());

        loginScreen.login();
        inventory.addToCartByProductName("Sauce Labs Backpack");
        inventory.addToCartByProductName("Sauce Labs Bike Light");
        inventory.scrollDown(0.5);
        inventory.addToCartByProductName("Sauce Labs Bolt T-Shirt");
        inventory.addToCartByProductName("Sauce Labs Fleece Jacket");
        inventory.scrollDown(0.7);
        inventory.addToCartByProductName("Sauce Labs Onesie");
        inventory.addToCartByProductName("Test.allTheThings() T-Shirt (Red)");

        // otomatis scroll dan klik

        int expected = 6;
        int actual = inventory.getTotalCart();

        Assert.assertEquals(actual, expected);

        DriverManager.quitDriver();
    }

}
