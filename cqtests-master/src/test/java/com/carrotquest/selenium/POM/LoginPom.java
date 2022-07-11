package com.carrotquest.selenium.POM;


import org.openqa.selenium.By;

public class LoginPom {


    //кнопка войти
    public static By getEnterBtnId() {
        return By.cssSelector("[test-id='loginForm.login.signInButton']");
    }

    //подсказка getEmailId
    public static By getHintEmailId (){
        return By.cssSelector("div:nth-child(2) > ng-messages > ng-message");
    }

    //подсказка password
    public static By getHintPassId (){
        return By.cssSelector("div:nth-child(3) > ng-messages > ng-message");
    }

    //getEmailId поле ввода
    public static By getEmailId(){
        return By.cssSelector("[test-id='loginForm.email']");
    }

    //password поле ввода
    public static By getPasswordId(){
        return By.cssSelector("[test-id='loginForm.password']");
    }

    //текст Мои сайты
    public static By getAkkTextId(){
        return By.cssSelector(".active > a > uib-tab-heading > span");
    }




}
