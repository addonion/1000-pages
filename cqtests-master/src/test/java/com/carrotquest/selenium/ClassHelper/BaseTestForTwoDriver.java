package com.carrotquest.selenium.ClassHelper;

import com.carrotquest.selenium.ClassHelper.BaseTestForOneDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class BaseTestForTwoDriver  extends BaseTestForOneDriver {



    protected CarrotWebDriver newDriver = null;
    int i = 1;

    public BaseTestForTwoDriver() {
        super();
        newDriver = new CarrotWebDriver();

    }


    @AfterTest
    public void closeWindow() {
        newDriver.close();
        newDriver.quit();
    }
}
