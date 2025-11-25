package com.swaglabs.mobile.screens;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.swaglabs.mobile.component.HeaderComponent;
import com.swaglabs.mobile.utils.DragPositionUtil;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class InventoryScreen {

    private final AndroidDriver driver;

    // ===============================
    // Locators
    // ===============================
    private final By titleHeader = AppiumBy.xpath("//android.widget.TextView[@text='PRODUCTS']");
    private final By productCards = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Item']");
    private final By scrollView = AppiumBy.xpath("//android.widget.ScrollView[@content-desc='test-PRODUCTS']");
    private final By dragHandle = AppiumBy.xpath("(//android.view.ViewGroup[@content-desc='test-Drag Handle'])[1]");

    private final HeaderComponent headerComponent;

    // ===============================
    // Constructor
    // ===============================
    public InventoryScreen(AndroidDriver driver) {
        this.driver = driver;
        this.headerComponent = new HeaderComponent(driver);
    }

    // ===============================
    // Getters
    // ===============================
    public String getTitle() {
        return driver.findElement(titleHeader).getText();
    }

    public int getTotalProduct() {
        return driver.findElements(productCards).size();
    }

    public int getTotalCart() {
        try {
            WebElement badge = driver.findElement(headerComponent.getCartBadge());
            return Integer.parseInt(badge.getText());
        } catch (Exception e) {
            return 0; // bila badge tidak muncul (cart kosong)
        }
    }

    // ===============================
    // Scroll
    // ===============================
    public void scrollDown(double percent) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Map<String, Object> params = new HashMap<>();
        params.put("elementId", driver.findElement(scrollView));
        params.put("direction", "down");
        params.put("percent", percent);
        params.put("speed", 1000);

        js.executeScript("mobile: scrollGesture", params);
    }

    // ===============================
    // Drag
    // ===============================
    public void drag(DragPositionUtil dragPositionUtil) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Map<String, Object> params = new HashMap<>();

        WebElement scrollEl = driver.findElement(scrollView);
        int x = scrollEl.getLocation().getX() + dragPositionUtil.getCustomX();
        int y = scrollEl.getLocation().getY() - dragPositionUtil.getCustomY();

        params.put("elementId", driver.findElement(dragHandle));
        params.put("endX", x);
        params.put("endY", y);
        params.put("speed", 5000);

        js.executeScript("mobile: dragGesture", params);
    }

    // ===============================
    // Add To Cart (Normal)
    // ===============================
    private By getAddToCartButton(String productName) {
        return AppiumBy.xpath(
                "//android.widget.TextView[@text='" + productName + "']"
                        + "/../..//android.view.ViewGroup[@content-desc='test-ADD TO CART']");
    }

    public void addToCartByProductName(String productName) {
        WebElement btn = driver.findElement(getAddToCartButton(productName));
        btn.click();
    }

}
