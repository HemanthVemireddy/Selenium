package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class WebTabul_ColoumPosition_Changed {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/test/write-xpath-table.html");
        driver.manage().window().maximize();

        WebElement table = driver.findElement(By.xpath("/html/body/center/table"));

        // 1️⃣ Read all headers (dynamic)
        List<WebElement> headers = table.findElements(By.xpath(".//th"));

        int targetIndex = -1;
        String targetColumnName = "Course";   // example column (can be any)

        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getText().equalsIgnoreCase(targetColumnName)) {
                targetIndex = i + 1;   // XPath uses 1-based index
                break;
            }
        }

        if (targetIndex == -1) {
            System.out.println("Column not found: " + targetColumnName);
            driver.quit();
            return;
        }

        System.out.println("Column '" + targetColumnName + "' found at index: " + targetIndex);

        // 2️⃣ Now print only that specific column for all rows
        List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        for (int r = 2; r <= rows.size(); r++) { // skip header row
            WebElement cell = table.findElement(By.xpath(".//tr[" + r + "]/td[" + targetIndex + "]"));
            System.out.println(cell.getText());
        }

        driver.quit();
    }
}
