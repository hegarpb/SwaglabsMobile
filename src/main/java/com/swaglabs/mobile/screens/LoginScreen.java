package com.swaglabs.mobile.screens;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class LoginScreen {
    private AndroidDriver driver;

    private By username = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
    private By password = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
    private By btnLogin = AppiumBy.xpath("//android.widget.TextView[@text=\"LOGIN\"]");
    private By errMessage = AppiumBy
            .xpath("//android.view.ViewGroup[@content-desc=\"test-Error message\"]//android.widget.TextView");

    public LoginScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(this.username).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(this.password).sendKeys(password);
    }

    public void clickBtnLogin() {
        driver.findElement(this.btnLogin).click();
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickBtnLogin();
    }

    public void login() {
        login("standard_user", "secret_sauce");
    }

    public String getErrMsg() {
        return driver.findElement(errMessage).getText();
    }

}
