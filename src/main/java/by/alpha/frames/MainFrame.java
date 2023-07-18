package by.alpha.frames;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import io.appium.java_client.AppiumBy;

@Component
public class MainFrame extends BaseFrame {

    private final By successLoginTxt = By.xpath("//*[@text='Вход в Alfa-Test выполнен']");

    public boolean isSuccessLoginTextPresented() {
        return isElementPresentedWithWaiting(successLoginTxt);
    }
}
