package by.alpha.driver;

import static org.openqa.selenium.remote.CapabilityType.PLATFORM_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.APP;
import static io.appium.java_client.remote.MobileCapabilityType.AUTOMATION_NAME;
import static io.appium.java_client.remote.MobileCapabilityType.DEVICE_NAME;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.*;

import com.codeborne.selenide.WebDriverProvider;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.Nonnull;

import io.appium.java_client.android.AndroidDriver;

@Component
public class AndroidDriverProvider implements WebDriverProvider {

    @Value("${device.name}")
    public String deviceName;
    @Value("${app.package}")
    public String appPackage;
    @Value("${app.activity}")
    public String appActivity;
    @Value("${apk.path}")
    public String apkPath;
    @Value("${appium.url}")
    public String appiumUrl;

    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(AUTO_GRANT_PERMISSIONS, true);
        desiredCapabilities.setCapability(DEVICE_NAME, deviceName);
        desiredCapabilities.setCapability(PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(APP_PACKAGE, appPackage);
        desiredCapabilities.setCapability(APP_ACTIVITY, appActivity);
        desiredCapabilities.setCapability(AUTOMATION_NAME, "UiAutomator2");
        desiredCapabilities.setCapability(APP, new File(apkPath).getAbsolutePath());
        try {
            return new AndroidDriver(new URL(appiumUrl), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
