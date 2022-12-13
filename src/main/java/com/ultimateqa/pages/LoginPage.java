package com.ultimateqa.pages;

import com.ultimateqa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage extends Utility {
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Sign In']")
    WebElement signinLink;

    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Welcome Back!']")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(id = "user[email]")
    WebElement userNameField;

    @CacheLookup
    @FindBy(id = "user[password]")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "/button[normalize-space()='Sign in'])")
    WebElement signInButton;

    @CacheLookup
    @FindBy(xpath = "//div[@id='notice']//ul[1]//li[1]")
    WebElement errorMessage;



    public void clickOnSigninLink() {
        clickOnElement(signinLink);
    }

    public String getWelcomeText() {
        Reporter.log("Get secure text " + welcomeText.toString());
        return getTextFromElement(welcomeText);
    }

    public void enterUserName(String username) {
        Reporter.log("Enter username " + username + " to username field " + userNameField.toString());
        sendTextToElement(userNameField, username);

    }

    public void enterPasswordToPasswordField(String password) {
        Reporter.log("Enter password " + password + " to password field " + passwordField.toString());
        sendTextToElement(passwordField, password);
    }

    public void clickOnSignInButton() {
        Reporter.log("Clicking on Login Button " + signInButton.toString());
        clickOnElement(signInButton);
    }

    public String getErrorMessage() {
        Reporter.log("Get error Message"+errorMessage.toString());
        return getTextFromElement(errorMessage);
    }

}
