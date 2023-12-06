package org.example.Selenium;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {
    public static String Driver ="webdriver.chrome.driver";

    public static String path ="H:\\Drivers\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";

    public static void main(String[] args) throws InterruptedException {
        System.setProperty(Driver, path);

        WebDriver driver = new ChromeDriver();

        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

        driver.manage().window().maximize();


        WebElement web = driver.findElement(By.xpath("//input[@type='submit']"));
        web.click();
        //web.wait(100);


        //Using Alert class interface

        org.openqa.selenium.Alert a = driver.switchTo().alert();

        // Way 1
        String alertMessage = a.getText();
        System.out.println("Printing Alert Message :\t"+ alertMessage);

        // Way 2
        a.dismiss();

        web.click();
        //web.wait(100);

        // Way 3
        a.accept();

        driver.quit();

    }
}
