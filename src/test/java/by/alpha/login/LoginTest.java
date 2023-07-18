package by.alpha.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import by.alpha.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        loginFrame.setLoginAndPass("Login", "Password");
        loginFrame.clickLoginBtn();
        Assertions.assertTrue(mainFrame.isSuccessLoginTextPresented(), "Success login text not presented");
    }

    @Test
    public void incorrectPassTest() {
        loginFrame.setLoginAndPass("Login", "incorrect_pass");
        loginFrame.clickLoginBtn();
        Assertions.assertTrue(loginFrame.isLoginErrorMessagePresented(), "Error message not presented");
        Assertions.assertFalse(mainFrame.isSuccessLoginTextPresented(), "Success login text mustn't be presented");
    }

    @Test
    public void insertingLoginWithInvalidCharsTest() {
        loginFrame.setLoginAndPass("неверныйLogin", "Password");
        Assertions.assertEquals("Login", loginFrame.getLoginVal(), "Login was not changed after inserting");
    }

    @Test
    public void viewPassTest() {
        String pass = "Password";
        loginFrame.setLoginAndPass("Login", pass);
        Assertions.assertTrue(loginFrame.isPassMasked(), "Password not masked");
        loginFrame.clickOnViewPass();
        Assertions.assertFalse(loginFrame.isPassMasked(), "Password masked");

    }
}
