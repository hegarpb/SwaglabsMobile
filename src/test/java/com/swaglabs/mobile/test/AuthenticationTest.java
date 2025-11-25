package com.swaglabs.mobile.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.swaglabs.mobile.screens.InventoryScreen;
import com.swaglabs.mobile.screens.LoginScreen;
import com.swaglabs.mobile.driver.DriverManager;

public class AuthenticationTest {

    @Test(dataProvider = "loginDataProvider", dataProviderClass = DataTestProvider.class)
    public void loginTest(String username, String password, String expected) {

        // Init page objects
        LoginScreen loginScreen = new LoginScreen(DriverManager.getDriver());
        InventoryScreen inventoryScreen = new InventoryScreen(DriverManager.getDriver());

        // Perform login
        loginScreen.login(username, password);

        String actual;

        // CASE 1 → Login sukses (expected kosong)
        if (expected == null || expected.trim().isEmpty()) {
            actual = inventoryScreen.getTitle();
            Assert.assertEquals(actual, "PRODUCTS", "Login sukses tetapi title tidak sesuai!");
        }

        // CASE 2 → Login gagal (expected berisi error message)
        else {
            actual = loginScreen.getErrMsg();
            Assert.assertEquals(actual, expected, "Error message login tidak sesuai!");
        }

        // Quit after test
        DriverManager.quitDriver();
    }
}
