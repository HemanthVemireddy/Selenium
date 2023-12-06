package org.example.Selenium;


import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.sql.Driver;

public class Cookies {
    public static void main(String[] args) throws FileNotFoundException {
        WebElements web = new WebElements();
        String location = web.getDriver();
        String path = web.getPath();

        System.setProperty(location,path);

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.browserstack.com/guide/how-to-handle-cookies-in-selenium");


        // To Return List of Cookies

        var cookies = driver.manage().getCookies();
        int length = cookies.toArray().length;
        for(int i = 0; i< length; i++) {
            System.out.println("List Of Cookies .... :\t" + cookies.stream().toList().get(i));
        }

        Cookie SpecificNameCookie = driver.manage().getCookieNamed("path");
        if(SpecificNameCookie!= null)
        {
            System.out.println("Specific Cookies ....: \t" + SpecificNameCookie.getName());
        }
        else {
            System.out.println("Not Found");
        }

        Cookie cook = new Cookie("Value","Hemanth");

        driver.manage().addCookie(cook);
        driver.manage().deleteCookie(cook);


//        Dimension d = new Dimension(100,200);
//        driver.manage().window().setSize(d);

//        String URL = driver.getCurrentUrl();
//        System.out.println("Current URL Address : \t"+URL);
//
//        String Title = driver.getTitle();
//
//        System.out.println("Current URL Address Title : \t"+Title);
//
//        String pageSource = driver.getPageSource();
//        System.out.println("Current URL PageSource : \t"+pageSource);
//
//        PrintStream fs = new PrintStream(new File("./PageSource.html"));
//        fs.print(pageSource);

        driver.quit();
    }
}
