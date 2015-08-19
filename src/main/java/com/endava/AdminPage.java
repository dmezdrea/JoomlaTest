package com.endava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by dmezdrea on 8/18/2015.
 */
public class AdminPage {

    private WebDriver driver;

    /*Add New User from Admin Control Panel*/
    @FindBy(xpath = "//span[contains(.,'User Manager')]")
    private WebElement userMng;

    @FindBy(xpath = "//button[contains(.,'New')]")
    private WebElement newUserButton;

    @FindBy(id = "jform_name")
    private WebElement nameNewUser;

    @FindBy(id = "jform_username")
    private WebElement userNameNewUser;

    @FindBy(id = "jform_password")
    private WebElement passNewUser;

    @FindBy(id = "jform_password2")
    private WebElement passRepeat;

    @FindBy(id = "jform_email")
    private WebElement emailUserNew;

    @FindBy(xpath = "//button[contains(.,'Save & Close')]")
    private WebElement saveCloseUsr;

    /*Edit User Privileges from Control Panel*/
    @FindBy(xpath = "//a[@title='Edit User Test Endava']")
    private WebElement clickUserToEdit;

    @FindBy(xpath = "//a[contains(.,'Assigned User Groups')]")
    private WebElement AssignUser;

    @FindBy(xpath = "//label[@for='1group_7']")
    private WebElement AssignAdmin;

    @FindBy(xpath = "//button[contains(.,'Save & Close')]")
    private WebElement SaveCloseAssign;

    @FindBy(xpath = "//a[@href='/joomla/administrator']")
    private WebElement iconJoomla;

    /*Add New Article from Admin Control Panel*/
    @FindBy(xpath = "//span[contains(.,'Add New Article')]")
    private WebElement addNewArtCP;

    @FindBy(id = "jform_title")
    private WebElement titleFieldNewArtCP;

    @FindBy(xpath = "//a[@title='Toggle editor']")
    private WebElement toggleCP;

    @FindBy(id = "jform_articletext")
    private WebElement textArtCP;

    @FindBy(xpath = "//button[contains(.,'Save & Close')]")
    private WebElement saveCloseArtCP;

    /*Open HomePage*/
    @FindBy(xpath = "//a[@class='brand visible-desktop visible-tablet']")
    private WebElement openHomePage;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
    }

    /*Add new user*/
    public void userAdd(String name, String usernme, String passwd, String passrpt, String emailUsr) {
        userMng.click();
        newUserButton.click();
        nameNewUser.sendKeys(name);
        userNameNewUser.sendKeys(usernme);
        passNewUser.sendKeys(passwd);
        passRepeat.sendKeys(passrpt);
        emailUserNew.sendKeys(emailUsr);
        saveCloseUsr.click();
        iconJoomla.click();
    }

    /*Manage User Privileges*/
    public void userManage() {
        userMng.click();
        clickUserToEdit.click();
        AssignUser.click();
        AssignAdmin.click();
        SaveCloseAssign.click();
    }

    /*Add New Article from Admin Control Panel*/
    public void addArticle(String titleCP, String textCP) {
        addNewArtCP.click();
        titleFieldNewArtCP.sendKeys(titleCP);
        toggleCP.click();
        textArtCP.sendKeys(textCP);
        saveCloseArtCP.click();
        openHomePage.click();
    }
}
