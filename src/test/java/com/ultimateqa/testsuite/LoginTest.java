package com.ultimateqa.testsuite;

import com.ultimateqa.customlisteners.CustomListeners;
import com.ultimateqa.pages.LoginPage;
import com.ultimateqa.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
    LoginPage loginPage;
    @BeforeMethod
    public void inIt(){
        loginPage =new LoginPage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldNavigateToLoginPageSuccessfully() {
        loginPage.clickOnSigninLink();
        String expectedText = "Welcome Back!";
        //String actualText = loginPage.getWelcomeText();
        Assert.assertEquals(loginPage.getWelcomeText(), expectedText, "correct text");
    }
    @Test(groups = {"smoke","regresssion"})
    public void verifyTheErrorMessage(){
        loginPage.clickOnSigninLink();
        loginPage.enterUserName("abc");
        loginPage.enterPasswordToPasswordField("abc123");
        loginPage.clickOnSignInButton();
        String expectedText="Invalid email or password.";

        Assert.assertEquals(loginPage.getErrorMessage(),expectedText,"correct text");

    }

}
