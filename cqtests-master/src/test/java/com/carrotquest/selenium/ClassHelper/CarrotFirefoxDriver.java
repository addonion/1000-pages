package com.carrotquest.selenium.ClassHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CarrotFirefoxDriver extends org.openqa.selenium.firefox.FirefoxDriver {

    public WebElement getBySelector (String selector){
        return findElement(By.cssSelector(selector));
    }
    public WebElement getByXpath (String xpath){
        return findElement(By.xpath(xpath));
    }

    public void clickBy(By selector){
        this.findElement(selector).click();
    }

    public String getTextBy (By selector){
       return this.findElement(selector).getText();
    }

    public void sendKeysBy(By selector, String stringSendKeys){
        this.findElement(selector).sendKeys(stringSendKeys);
    }

    public void clearBy (By selector){
        this.findElement(selector).clear();
    }

    public boolean isDisplayedBy(By selector){
        return this.findElement(selector).isDisplayed();
    }

    public WebElement returnWebElementBy(By selector){
        return this.findElement(selector);
    }
}
