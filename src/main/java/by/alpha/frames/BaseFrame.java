package by.alpha.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import dev.failsafe.internal.util.Durations;

@Component
public abstract class BaseFrame {

    @Autowired
    @Lazy
    protected WebDriver driver;

    protected boolean isElementPresentedWithWaiting(By locator) {
        try {
            new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class)
                    .until(driver -> driver.findElement(locator));
            return true;
        } catch (TimeoutException ignored) {
            return false;
        }
    }
}
