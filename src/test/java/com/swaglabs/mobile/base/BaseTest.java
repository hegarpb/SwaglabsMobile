package com.swaglabs.mobile.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.swaglabs.mobile.driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverManager.getDriver();
    }

    @AfterMethod
    public void teardown() {
        DriverManager.quitDriver();
    }
}
