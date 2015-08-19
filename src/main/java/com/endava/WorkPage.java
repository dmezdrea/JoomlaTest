package com.endava;

import com.sun.jna.platform.FileUtils;
import org.apache.bcel.generic.Select;
import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.io.File;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmezdrea on 8/18/2015.
 */
public class WorkPage {

    private WebDriver driver;

    /*Login Administrator*/
    @FindBy(xpath = "//a[@href='/joomla/administrator']")
    private WebElement siteAdmin;

    @FindBy(id = "mod-login-username")
    private WebElement userFieldAdmin;

    @FindBy(id = "mod-login-password")
    private WebElement passFieldAdmin;

    @FindBy(xpath = "//button[contains(.,'Log in')]")
    private WebElement loginButtonAdmin;

    /*Manage Categories*/
    @FindBy(xpath = "//span[contains(.,'Category Manager')]")
    private WebElement catmanagerButton;

    @FindBy(xpath = "//button[contains(.,'New')]")
    private WebElement newCategory;

    @FindBy(xpath = "//input[@name='jform[title]']")
    private WebElement titleFieldCat;

    @FindBy(xpath = "//input[@name='jform[alias]']")
    private WebElement aliasCat;

    @FindBy(xpath = "//a[@title='Toggle editor']")
    private WebElement toggleEdCat;

    @FindBy(id = "jform_description")
    private WebElement textFieldCategory;

    @FindBy(xpath = "//button[contains(.,'Save & Close')]")
    private WebElement saveClose;

    /*Template Settings from HomePage*/
    @FindBy(xpath = "//span[@class='icon-edit']")
    private WebElement iconEdit;

    @FindBy(xpath = "//a[contains(.,'Template Settings')]")
    private WebElement templateSettings;

    @FindBy(id = "params_templateColor")
    private WebElement temColour;

    @FindBy(id = "params_templateBackgroundColor")
    private WebElement backColour;

    @FindBy(id = "params_sitetitle")
    private WebElement titleFront;

    @FindBy(id = "params_sitedescription")
    private WebElement description;

    @FindBy(xpath = "//button[contains(.,'Save')]")
    private WebElement saveColour;

    /*Site Settings from HomePage*/
    @FindBy(xpath = "//a[contains(.,'Site Settings')]")
    private WebElement siteSettings;

    @FindBy(xpath = "//input[@id='jform_sitename']")
    private WebElement siteNameLabel;

    @FindBy(id = "jform_MetaDesc")
    private WebElement metaDescr;

    @FindBy(id = "jform_MetaKeys")
    private WebElement metaKeys;

    @FindBy(xpath = "//button[contains(.,'Save')]")
    private WebElement saveSiteSettings;

    /*Search Field*/
    @FindBy(id = "mod-search-searchword")
    private WebElement searchFld;

    /*Edit an article from Control Panel*/
    @FindBy(xpath = "//span[contains(.,'Article Manager')]")
    private WebElement articleMangerCP;

    @FindBy(xpath = "//a[contains(.,'Getting Started')]")
    private WebElement articleClickToEdit;

    @FindBy(xpath = "//a[@title='Toggle editor']")
    private WebElement toggleEdfromCP;

    @FindBy(id = "jform_articletext")
    private WebElement editLabelArt;

    @FindBy(xpath = "//a[contains(.,'Publishing')]")
    private WebElement publish;

    @FindBy(id = "jform_publish_down")
    private WebElement FinishPub;

    @FindBy(xpath = "//button[contains(.,'Save & Close')]")
    private WebElement saveEditArt;

    /*Template manager from CP*/
    @FindBy(xpath = "//span[contains(.,'Template Manager')]")
    private WebElement temManagerCP;

    @FindBy(xpath = "//a[contains(.,'Beez3 - Default')]")
    private WebElement BeezTemp;

    @FindBy(xpath = "//a[contains(.,'Advanced')]")
    private WebElement AdvanceBeez;

    @FindBy(id = "jform_params_backgroundcolor")
    private WebElement colorBeez;

    @FindBy(xpath = "//button[contains(.,'Save & Close')]")
    private WebElement saveCloseBeez;


    public WorkPage(WebDriver driver) {
        this.driver = driver;
    }

    /*Admin Login*/
    public void admin(String userAd, String passAd) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        siteAdmin.click();
        userFieldAdmin.sendKeys(userAd);
        passFieldAdmin.sendKeys(passAd);
        loginButtonAdmin.click();
    }

    /*Manage Categories*/
    public void categoryManage(String titleCat, String aliasC, String textCat) {
        catmanagerButton.click();
        newCategory.click();
        titleFieldCat.sendKeys(titleCat);
        aliasCat.sendKeys(aliasC);
        toggleEdCat.click();
        textFieldCategory.sendKeys(textCat);
        saveClose.click();
    }

    /*Edit Template Settings from HomePage*/
    public void edit(String colour, String bkColour, String frontTitle, String descrpt) {
        templateSettings.click();
        temColour.clear();
        temColour.sendKeys(colour);
        backColour.clear();
        backColour.sendKeys(bkColour);
        titleFront.clear();
        titleFront.sendKeys(frontTitle);
        description.clear();
        description.sendKeys(descrpt);
        saveColour.click();
    }

    /*Edit Site Settings from HomePage*/
    public void siteEdit(String siteNameText, String meta, String metaK) {
        siteSettings.click();
        siteNameLabel.clear();
        siteNameLabel.sendKeys(siteNameText);
        metaDescr.clear();
        metaDescr.sendKeys(meta);
        metaKeys.clear();
        metaKeys.sendKeys(metaK);
        saveSiteSettings.click();
    }

    /*Search Method*/
    public void searchIn(String searchUp) {
        searchFld.sendKeys(searchUp);
        searchFld.submit();
    }

    /*Edit Article from Control Panel*/
    public void editArtCP(String labelArt,String datee) throws InterruptedException {
        articleMangerCP.click();
        articleClickToEdit.click();
        Thread.sleep(5000);
        toggleEdfromCP.click();
        editLabelArt.clear();
        editLabelArt.sendKeys(labelArt);
        publish.click();
        FinishPub.clear();
        FinishPub.sendKeys(datee);
        saveEditArt.click();
    }

    public void templateMng(String cbeez){
        temManagerCP.click();
        BeezTemp.click();
        AdvanceBeez.click();
        colorBeez.clear();
        colorBeez.sendKeys(cbeez);
        saveCloseBeez.click();
    }


}
