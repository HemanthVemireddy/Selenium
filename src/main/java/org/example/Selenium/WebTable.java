package org.example.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTable {
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","H:\\Drivers\\ChromeDriver\\chromedriver-win64\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/write-xpath-table.html");

        driver.manage().window().maximize();

        WebElement table = driver.findElement(By.xpath("/html/body/center/table"));


        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int rows_count = rows.size();

        for(int i = 0 ; i< rows_count; i++)
        {
            List<WebElement> colu = rows.get(i).findElements(By.tagName("td"));
            int col_count = colu.size();

            for (int j =0; j<col_count; j++)
            {
                String tex = colu.get(j).getText();
                System.out.println("Print .......\t"+tex);
            }
            System.out.println("");

        }

        driver.quit();


    }
}
