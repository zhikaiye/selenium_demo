package com.selenium.autotest.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ChromeDriver {
    static WebDriver chromeDriver;
    public void startBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        System.out.println(System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver","/Users/zhikaiye/Selenium/ChromeDriver/chromedriver");
        chromeDriver = new org.openqa.selenium.chrome.ChromeDriver();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
    }
}
