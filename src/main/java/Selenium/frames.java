package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class frames
{
    @Test
    public  void Test()
    {
        WebDriver driver = new ChromeDriver();

        driver.switchTo().frame(9);
        // Index
        // Name or Id
        // WebElement

        driver.switchTo().defaultContent();
        // Switch to Default Content


        driver.switchTo().parentFrame();
        // Switch to parent Window
    }
}
