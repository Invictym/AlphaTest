package by.alpha.frames;

import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class LoginFrame extends BaseFrame {

    private final By loginInput = AppiumBy.id("etUsername");
    private final By viewPass = AppiumBy.id("text_input_end_icon");
    private final By passInput = By.xpath("//*[@resource-id='com.alfabank.qapp:id/etPassword']");
    private final By loginBtn = AppiumBy.id("btnConfirm");
    private final By loginErrorMessageTxt = By.xpath("//android.widget.TextView[@resource-id='com.alfabank.qapp:id/tvError']");

    public void setLoginAndPass(String login, String pass) {
        driver.findElement(loginInput).sendKeys(login);
        driver.findElement(passInput).sendKeys(pass);
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }

    public boolean isLoginErrorMessagePresented() {
        return isElementPresentedWithWaiting(loginErrorMessageTxt);
    }

    public void clickOnViewPass() {
        driver.findElement(viewPass).click();
    }

    public boolean isPassMasked() {
        return Boolean.parseBoolean(driver.findElement(passInput).getAttribute("password"));
    }

    public String getLoginVal() {
        return driver.findElement(loginInput).getText();
    }
}
