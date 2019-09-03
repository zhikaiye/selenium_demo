package com.selenium.autotest.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pages {


    @FindBy(id = "aaa")
    WebElement findaaa;

    Pages(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    public void setkk(){
        findaaa.sendKeys("aaa");
    }
}
