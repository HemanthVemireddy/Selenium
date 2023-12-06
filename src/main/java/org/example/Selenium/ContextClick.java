package org.example.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContextClick {
    public static String Driver ="webdriver.chrome.driver";

    public static String path ="H:\\Drivers\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";
    public static void main(String[] args)  {
        try {
            System.setProperty(Driver, path);

            WebDriver driver = new ChromeDriver();

            driver.get("https://www.google.com/");
            driver.manage().window().maximize();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Google']")));
            Actions ac = new Actions(driver);
            // Thread.sleep(Duration.ofMinutes(1));
            WebElement ele = driver.findElement(By.xpath("//div[@aria-label='Search by voice']"));
            WebElement eoo = driver.findElement(By.xpath("//div[@aria-label='Search by image']"));
//        ac.contextClick(ele).build().perform();
//        Thread.sleep(Duration.ofMinutes(1));
//        ac.clickAndHold(ele).build().perform();

            ac.moveToElement(ele).perform();
            ac.moveToElement(eoo).perform();
            //WebDriverWait waits = new WebDriverWait(driver, Duration.ofMinutes(1));
            //waits.until(ExpectedConditions.attributeToBe(ele, ele.getText(), "Search"));


            driver.quit();
        }
        catch (Exception e)
        {
           System.out.println("Fail"+e);
        }

    }

}
