package com.endava;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

/**
 * Created by dmezdrea on 8/17/2015.
 */
public class LoginPage {

    private WebDriver driver;

    /*Login User*/
    @FindBy(id = "modlgn-username")
    private WebElement usernameField;

    @FindBy(id = "modlgn-passwd")
    private WebElement passwdField;

    @FindBy(xpath = "//button[contains(.,'Log in')]")
    private WebElement login;

    @FindBy(xpath = "//h3[contains(.,'User Menu')]")
    private WebElement userMenu;

    @FindBy(className = "login-greeting")
    private WebElement logingreeting;

    /*Your Profile Option*/
    @FindBy(xpath = "//a[contains(.,'Your Profile')]")
    private WebElement yourProfile;

    @FindBy(xpath = "//input[@id='jform_name']")
    private WebElement changeName;

    @FindBy(xpath = "//button[contains(@type,'submit')]")
    private WebElement submitProfile;

    /*Create Article*/
    @FindBy(xpath = "//a[contains(.,'Submit an Article')]")
    private WebElement submitArticle;

    @FindBy(id = "jform_title")
    private WebElement articleTitle;

    @FindBy(xpath = "//a[@title='Toggle editor']")
    private WebElement toggleEditor;

    @FindBy(id = "jform_articletext")
    private WebElement textArticle;

    @FindBy(xpath = "//button[contains(.,'Save')]")
    private WebElement saveArticle;

    /*Logout*/
    @FindBy(xpath = "//input[@value='Log out']")
    private WebElement logOut;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /*User Authentication*/
    public void autentificare(String user, String pass) {
        usernameField.sendKeys(user);
        passwdField.sendKeys(pass);
        login.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        userMenu.isDisplayed();
        logingreeting.isDisplayed();
    }

    /*Edit Profile*/
    public void profile(String nameProfile) {
        yourProfile.click();
        System.out.println("Show page: " + yourProfile.getText());
        changeName.clear();
        changeName.sendKeys(nameProfile);
        submitProfile.click();
    }

    /*Create article from HomePage*/
    public void article(String title, String text) {
        submitArticle.click();
        articleTitle.sendKeys(title);
        toggleEditor.click();
        textArticle.sendKeys(text);
        saveArticle.click();
    }

    /*User Logout*/
    public void logout() {
        logOut.click();
    }
}
