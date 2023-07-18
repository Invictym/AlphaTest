package by.alpha;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;

import by.alpha.frames.LoginFrame;
import by.alpha.frames.MainFrame;

@SpringBootTest(classes = TestApplication.class)
public abstract class BaseTest {

    @Autowired
    @Lazy
    public LoginFrame loginFrame;
    @Autowired
    @Lazy
    public MainFrame mainFrame;
    @Autowired
    ApplicationContext applicationContext;

    @BeforeEach
    public void beforeTest() {

    }

    @AfterEach
    public void teardown() {
        this.applicationContext
                .getBean(WebDriver.class)
                .quit();
    }

}
