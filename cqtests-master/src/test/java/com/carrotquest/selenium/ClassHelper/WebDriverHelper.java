package com.carrotquest.selenium.ClassHelper;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class WebDriverHelper {



    public static String getRndStr() {
        Date date = new Date();
        return String.valueOf(date.getTime());

    }



    public static void threadSleep(By selector, int count, CarrotWebDriver driver) throws InterruptedException {
        int i = count;
        boolean test = false;

        try {
            driver.findElement(selector);
            test= true;
        } catch (NoSuchElementException e) {
            test =  false;
        }

        if (i<10 && !test) {

            i++;

            Thread.sleep(5000);

        }
        //}
    }




}
