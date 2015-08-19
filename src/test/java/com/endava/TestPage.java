package com.endava;

import com.gargoylesoftware.htmlunit.Page;
import org.apache.bcel.generic.Select;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

/**
 * Created by dmezdrea on 8/17/2015.
 */
public class TestPage {

    LoginPage objpage;
    WorkPage wpage;
    AdminPage apage;
    WebDriver driver;

    @Before
    public void before() {
        driver = new FirefoxDriver();
        objpage = PageFactory.initElements(driver, LoginPage.class);
        wpage = PageFactory.initElements(driver, WorkPage.class);
        apage = PageFactory.initElements(driver, AdminPage.class);
        driver.manage().window().maximize();
    }

    @After
    public void after() {
        driver.close();
    }

    @Test  /*First Test*/
    public void test() {
        driver.get("http://localhost:8081/joomla/");
        objpage.autentificare("cristidm", "ot26mez");
        String lg = driver.findElement(By.className("login-greeting")).getText();
        System.out.println("Login Successful: " + lg);
        String title = driver.getTitle();
        System.out.println("Titlul este: " + title);
        assertTrue(driver.getTitle().contains("Home"));
        objpage.profile("Cristi DM");
        String profileMessage = driver.findElement(By.xpath("//p[contains(.,'Profile successfully saved.')]")).getText();
        Assert.assertTrue("Message not found", profileMessage.contains("Profile successfully saved."));
        objpage.article("Next Article", "A simple article for the test");
        objpage.logout();

    }

    @Test /*Second Test*/
    public void test1() throws InterruptedException {
        driver.get("http://localhost:8081/joomla/");
        objpage.autentificare("cristidm", "ot26mez");
        wpage.admin("cristidm", "ot26mez");
        System.out.println("Titlul este: " + driver.getTitle());
        assertTrue(driver.getTitle().contains("cristidm's Site! - Administration"));
        System.out.println("Login Successful, Admin Control Panel: " + driver.getTitle());
        wpage.categoryManage("Test Category", "Alias test", "Aceasta este o categorie pentru test");
        System.out.println("Ne aflam in: " + driver.getTitle());
        Thread.sleep(5000);
        String categMessage = driver.findElement(By.xpath("//p[contains(.,'Category successfully saved.')]")).getText();
        Assert.assertTrue("Message not found", categMessage.contains("Category successfully saved."));
    }

    @Test  /*3rd Test*/
    public void test2() {
        driver.get("http://localhost:8081/joomla/");
        objpage.autentificare("cristidm", "ot26mez");
        wpage.edit("#0088cc", "#f4f6f7", "cristidm's Site!", "This is a test site for Endava");
        String colourChanged = driver.findElement(By.xpath("//p[contains(.,'Configuration successfully saved.')]")).getText();
        Assert.assertTrue("Colour not changed", colourChanged.contains("Configuration successfully saved."));
        System.out.println("Ne aflam in: " + driver.getTitle());
        wpage.siteEdit("cristidm's Site!", "Joomla! - the best content management system", "joomla, Joomla");
        System.out.println("Acum suntem in: " + driver.getTitle());
        wpage.searchIn("primul articol");
        String searchFirstArticle = driver.findElement(By.xpath("//legend[contains(.,'Search for:')]")).getText();
        Assert.assertTrue("Search not ok", searchFirstArticle.contains("Search for:"));
        System.out.println("Pagina de search: " + driver.getTitle());
    }

    @Test  /*4th Test*/
    public void test3() throws InterruptedException {
        driver.get("http://localhost:8081/joomla/");
        objpage.autentificare("cristidm", "ot26mez");
        wpage.admin("cristidm", "ot26mez");
        System.out.println("Page Location: " + driver.getTitle());
        WebElement ctrlPanel = driver.findElement(By.xpath("//h1[contains(.,'Control Panel')]"));
        Assert.assertEquals(true, ctrlPanel.isDisplayed());
        Thread.sleep(5000);
        apage.userAdd("Test Endava", "TestUser", "pass123", "pass123", "test@endava.com");
        apage.userManage();

    }

    @Test  /*5th Test*/
    public void test4() throws InterruptedException {
        driver.get("http://localhost:8081/joomla/");
        objpage.autentificare("cristidm", "ot26mez");
        wpage.admin("cristidm", "ot26mez");
        System.out.println("Ne aflam in: " + driver.getTitle());
        WebElement ctrlPanel = driver.findElement(By.xpath("//h1[contains(.,'Control Panel')]"));
        Assert.assertEquals(true, ctrlPanel.isDisplayed());
        apage.addArticle("Articol Test din AdminCP", "Acesta este un articol creat din Control Panel - Admin");
        Thread.sleep(5000);
        WebElement newArticleCreated = driver.findElement(By.xpath("//span[contains(.,'Articol Test din AdminCP')]"));
        Assert.assertEquals(true, newArticleCreated.isDisplayed());
    }

    @Test /*6th Test*/
    public void test5() throws InterruptedException {
        driver.get("http://localhost:8081/joomla/");
        objpage.autentificare("cristidm", "ot26mez");
        wpage.admin("cristidm", "ot26mez");
        wpage.editArtCP("TEST: Acesta este un articol EDITAT", "2016-04-22 11:49:28");
        Thread.sleep(5000);
        WebElement messageSuccess = driver.findElement(By.xpath("//p[contains(.,'Article successfully saved.')]"));
        Assert.assertEquals(true, messageSuccess.isDisplayed());
    }

    @Test /*7th Test*/
    public void test6() throws InterruptedException {
        driver.get("http://localhost:8081/joomla/");
        objpage.autentificare("cristidm", "ot26mez");
        wpage.admin("cristidm", "ot26mez");
        wpage.templateMng("#eeeeee");
        Thread.sleep(5000);
        WebElement styleSuccess = driver.findElement(By.xpath("//p[contains(.,'Style successfully saved.')]"));
        Assert.assertEquals(true, styleSuccess.isDisplayed());
    }
}
