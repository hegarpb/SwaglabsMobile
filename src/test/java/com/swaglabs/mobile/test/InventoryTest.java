package com.swaglabs.mobile.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.mobile.driver.DriverManager;
import com.swaglabs.mobile.screens.InventoryScreen;
import com.swaglabs.mobile.screens.LoginScreen;

public class InventoryTest {
    @Test(priority = 1)
    public void inventoryTest() {
        LoginScreen loginScreen = new LoginScreen(DriverManager.getDriver());
        InventoryScreen inventoryScreen = new InventoryScreen(DriverManager.getDriver());

        loginScreen.login();
        int actual = inventoryScreen.getTotalProduct();
        inventoryScreen.scrollDown(3);
        actual += inventoryScreen.getTotalProduct();

        int expected = 6;
        Assert.assertEquals(actual, expected);

        DriverManager.quitDriver();
    }

    @Test
    public void testSortPriceLowToHigh() throws InterruptedException {
        LoginScreen loginScreen = new LoginScreen(DriverManager.getDriver());
        InventoryScreen inventory = new InventoryScreen(DriverManager.getDriver());

        loginScreen.login();

        inventory.clickSortBtn();
        inventory.clickSortPriceLowToHigh();

        Assert.assertTrue(inventory.sortPriceLowToHigh(),
                "Harga tidak tersortir dari rendah ke tinggi!");
        DriverManager.quitDriver();
    }

}
