package by.alpha.config;

import com.codeborne.selenide.WebDriverProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import by.alpha.config.scope.WebDriverScopeBean;

@Configuration
public class WebDriverConfig {

    @Autowired
    private WebDriverProvider provider;

    @Bean
    @WebDriverScopeBean
    public WebDriver webDriver() {
        return provider.createDriver(new DesiredCapabilities());
    }

}
