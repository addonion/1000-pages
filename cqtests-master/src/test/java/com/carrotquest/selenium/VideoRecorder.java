package com.carrotquest.selenium;

import com.carrotquest.selenium.ClassHelper.BaseTestForOneDriver;
import org.monte.media.Format;
import org.monte.media.FormatKeys;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static org.monte.media.FormatKeys.MediaTypeKey;

public class VideoRecorder extends BaseTestForOneDriver {


    @Test(priority = 1)
    public void Test() throws Exception {



        driver.manage().window().setSize(new Dimension(1280, 800));
        driver.get("http://bitrix.carrotquest.ru");
        String url = driver.getCurrentUrl();
        url= url.replace("http://", "");
        url=url.replace("/","");
        String title = driver.getTitle();
        title=title.replace(" ", "");
        title=title.replace("\"", "");
        String name= "example"+"+"+url +"+"+title;
        VideoRecorder_utlity.startRecord(name);//
        Thread.sleep (3000);
        driver.switchTo().frame("carrot-messenger-collapsed-frame");
        driver.clickBy(By.cssSelector("#carrotquest-messenger-collapsed-img-cont"));
        Thread.sleep(3000);
        driver.switchTo().defaultContent ();

        driver.switchTo().frame("carrot-messenger-frame");
        driver.clickBy(By.cssSelector(".button_start-message"));
        Thread.sleep(3000);
        driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "Д");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "о");
        Thread.sleep(150); driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "б");
        Thread.sleep(150); driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "р");
        Thread.sleep(150); driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "ы");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "й");
        Thread.sleep(150); driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), " ");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "д");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "е");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "н");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "ь");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "!");
        Thread.sleep(150);

        driver.clickBy(By.xpath("//*[@id=\"carrotquest-messenger-reply\"]/div[2]/div[2]/button"));
        Thread.sleep(6000);
        driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "М");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "н");
        Thread.sleep(150); driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "е");
        Thread.sleep(150); driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), " ");
        Thread.sleep(150); driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "н");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "у");
        Thread.sleep(150); driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "ж");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "н");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "а");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), " ");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "в");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "а");
        Thread.sleep(150); driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "ш");
        Thread.sleep(150); driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "а");
        Thread.sleep(150); driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), " ");
        Thread.sleep(150); driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "п");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "о");
        Thread.sleep(150); driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "м");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "о");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "щ");
        Thread.sleep(150);driver.sendKeysBy(By.xpath("//*[@id=\"carrotquest-textfield\"]"), "ь");

        driver.clickBy(By.xpath("//*[@id=\"carrotquest-messenger-emoji-button\"]"));
        Thread.sleep(3000);
        driver.clickBy(By.xpath("//*[@id=\"carrotquest-messenger-emoji-list\"]/div[2]/div[1]/div[2]/div[11]/div"));
        Thread.sleep(2000);
        driver.clickBy(By.xpath("//*[@id=\"carrotquest-messenger-reply\"]/div[2]/div[2]/button"));
        Thread.sleep(6000);
        driver.clickBy(By.cssSelector(".close-button"));
        Thread.sleep(6000);


        VideoRecorder_utlity.stopRecord();

    }



    }



