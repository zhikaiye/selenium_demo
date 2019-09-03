import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class demo {
    WebDriver webDriver;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        System.out.println(System.getProperty("user.dir"));
        System.setProperty("webdriver.chrome.driver","/Users/zhikaiye/Selenium/ChromeDriver/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
    }

    @Test
    public void demotest1(){
        webDriver.get("https://www.baidu.com");
        webDriver.findElement(By.cssSelector("#kw")).sendKeys("mp3");

    }

    @Test
    public void switchToHandleTest(){
        webDriver.get("https://www.gxzg.org.cn/");
        webDriver.findElement(By.xpath("//*[@ class='notie']")).sendKeys("厦门纳网科技股份有限公司");
        webDriver.findElement(By.xpath("//*[@ class='box']/dl/dd/a")).click();
        String mainhandle = webDriver.getWindowHandle();
        webDriver.findElement(By.xpath("//*[@class='kwordRed']")).click();
        System.out.println(webDriver.getWindowHandle());
        for(String o : webDriver.getWindowHandles()){
            if (!o.equals(mainhandle)){
                System.out.println(o);
                webDriver.switchTo().window(o);
                break;
            }
        }

        webDriver.findElement(By.xpath("//*[@class='company-headHandle fr']/a[@class='see']")).click();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        webDriver.quit();
    }

}
