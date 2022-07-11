package com.carrotquest.selenium.ClassHelper;



import com.carrotquest.selenium.POM.Config;
import com.carrotquest.selenium.POM.LoginPom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTestForOneDriver {


    public EditSite siteEditor;

    public CarrotWebDriver driver = null;
    Date date = new Date();
    public By id;
    protected String currentUrl;


    public BaseTestForOneDriver (){
        System.setProperty("webdriver.chrome.driver", Config.chromeDriver());
        driver = new CarrotWebDriver();
        this.siteEditor = new EditSite(driver);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }




    public void enter() throws InterruptedException {


        driver.get(Config.urlLogin());

        //driver.manage().window().setSize(new Dimension(1920, 1080));
        Thread.sleep(5000);
        (new WebDriverWait(driver, 40)).until(ExpectedConditions.visibilityOfElementLocated(LoginPom.getEmailId()));
        WebElement dynamicElement1 = (new WebDriverWait(driver, 40)).until(ExpectedConditions.presenceOfElementLocated(LoginPom.getEmailId()));
        driver.sendKeysBy(LoginPom.getEmailId(),Config.emailStr());
        driver.sendKeysBy(LoginPom.getPasswordId(), Config.passStr());
        Thread.sleep(5000);
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.elementToBeClickable(LoginPom.getEnterBtnId()));

        driver.clickBy(LoginPom.getEnterBtnId());
        int i=0;
//        do {
//            Thread.sleep(5000);
//            WebElement element = LoginPom.getAkkTextId(driver);
//            if (element !=null && element.isDisplayed() && element.getText().equals("Мои сайты")) {
//                System.out.println("live ");
//                break;
//            }
//            driver.clickBy(LoginPom.getEnterBtnId());
//            System.out.println(" constructor");
//            i++;
//        }  while (i!=5);
        Thread.sleep(5000);
        WebElement dynamicElement = (new WebDriverWait(driver, 50)).until(ExpectedConditions.presenceOfElementLocated(LoginPom.getAkkTextId()));
        Assert.assertEquals(driver.getTextBy(LoginPom.getAkkTextId()), "Мои сайты");
    }

    @AfterTest
    public void test1() {
        driver.close();
        driver.quit();
    }
}
