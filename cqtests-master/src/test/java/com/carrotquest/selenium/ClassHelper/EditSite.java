package com.carrotquest.selenium.ClassHelper;

import com.carrotquest.selenium.POM.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EditSite  {

    private CarrotWebDriver driver;




    public EditSite(CarrotWebDriver driver){
        this.driver = driver;
    }







    public  boolean isElementPresent(By id) {
        try {
            driver.findElement(id);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public   void findSite ( ) throws InterruptedException {
        Thread.sleep(2000);
        int i = 1;
        if (isElementPresent(By.cssSelector(" tr:nth-child(2) > td:nth-child(2)")) == true) {
            while (!"bitrix3.carrotquest.ru".equals(driver.findElement(By.cssSelector(" tr:nth-child("+i+") > td:nth-child(2)")).getText()))
            {
                i++;
            }
            driver.findElement(By.cssSelector(" tr:nth-child("+i+") > td:nth-child(2)")).click();
        }
        else {
            driver.findElement(By.cssSelector("  tr > td.text-right > a")).click();
        }


    }

    public void whereSite() throws InterruptedException {
        Thread.sleep(5000);
        int i =1;
//        WebElement menu= AppPom.getAvatarId(driver);
//        Actions mouse = new Actions(driver);
//        mouse.moveToElement(menu).build().perform();
//        mouse.moveToElement(driver.findElement(By.cssSelector(" ul > li:nth-child(1) > a"))).click().build().perform();

        WebElement dynamicElement = (new WebDriverWait(driver, 60)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(" tr:nth-child(2) > td:nth-child(2)")));
        if (isElementPresent(By.cssSelector(" tr:nth-child(2) > td:nth-child(2)")) == true) {
            while (!ConstClass.NAME_COMPANY.equals(driver.findElement(By.cssSelector(" tr:nth-child("+i+") > td:nth-child(2)")).getText()))
            {
                i++;
            }
            Assert.assertEquals(driver.findElement(By.cssSelector(" tr:nth-child("+i+") > td:nth-child(2)")).getText(), ConstClass.NAME_COMPANY);
        }
        else {

        }
        Assert.assertEquals(driver.getTextBy(LoginPom.getAkkTextId()), "Мои сайты");
    }







}
