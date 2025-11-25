package com.swaglabs.mobile.component;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HeaderComponent {

    private final By cartBadge = AppiumBy
            .xpath("//android.view.ViewGroup[@content-desc='test-Cart']//android.widget.TextView");

    private final AndroidDriver driver;

    public HeaderComponent(AndroidDriver driver) {
        this.driver = driver;
    }

    public By getCartBadge() {
        return cartBadge;
    }
}
