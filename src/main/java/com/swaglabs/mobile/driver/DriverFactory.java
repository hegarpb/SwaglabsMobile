package com.swaglabs.mobile.driver;

import com.swaglabs.mobile.config.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URI;
import java.net.URL;
import java.time.Duration;

public class DriverFactory {

    public static AndroidDriver createAndroidDriver() {
        try {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", ConfigReader.get("platformName"));
            caps.setCapability("appium:deviceName", ConfigReader.get("deviceName"));
            caps.setCapability("appium:automationName", ConfigReader.get("automationName"));
            caps.setCapability("appium:appPackage", ConfigReader.get("appPackage"));
            caps.setCapability("appium:appActivity", ConfigReader.get("appActivity"));
            caps.setCapability("appium:disableHiddenApiPolicyError", true);

            // FIX: gunakan key yang benar
            URL serverUrl = URI.create(ConfigReader.get("appiumServerUrl")).toURL();

            AndroidDriver driver = new AndroidDriver(serverUrl, caps);

            // FIX: gunakan wait dari config
            int wait = Integer.parseInt(ConfigReader.get("implicitWait"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));

            return driver;

        } catch (Exception e) {
            throw new RuntimeException("Gagal membuat AndroidDriver: " + e.getMessage(), e);
        }
    }
}
