package org.example.Selenium;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
//import java.util.logging.FileHandler;

public class Screenshot {

    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.chrome.driver","H:\\Drivers\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://github.com/intel/haxm");
        driver.manage().window().fullscreen();


        // Converting web driver object to takescreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Call getScreenshotAs method to create image file
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);

        long CurrntTime = System.currentTimeMillis();
        File desFile = new File("./TakeScreenshot/Screenshot"+CurrntTime+".png");

        // Copy file at destination
        //Method1
        //FileUtils.copyFile(sourceFile,desFile);


        //method2
        FileHandler.copy(sourceFile,desFile);


        driver.quit();
        //C:\Users\HEMANTH KUMAR REDDY\Documents\Selenium

    }
}
