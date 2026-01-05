package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class brokenLinks3
{
    WebDriver driver;

    @Test
    public void CheckBrokenLinkes()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://www.amazon.in/");

        // Handle Popup (Amazon shows this sometimes)
        try {
            WebElement continueShopping = driver.findElement(By.xpath("//button[text()='Continue shopping']"));
            if (continueShopping.isDisplayed()) {
                continueShopping.click();
            }
        } catch (Exception ignored) {}

        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println("Total links found on page: " + links.size());

        for (WebElement link : links) {

            String url = link.getAttribute("href");

            // Skip empty or non-http links
            if (url == null || !url.startsWith("http")) {
                continue;
            }

            try {
                URL u = new URL(url);
                HttpURLConnection conn = (HttpURLConnection) u.openConnection();

                // Amazon blocks HEAD requests → so use GET
                conn.setRequestMethod("GET");
                conn.connect();

                int status = conn.getResponseCode();

                if (status >= 400) {
                    System.out.println(url + " ---> BROKEN (Status: " + status + ")");
                }
                // Else: Valid link, no need to print

            } catch (Exception e) {
                System.out.println(url + " ---> ERROR checking link: " + e.getMessage());
            }
        }

        driver.quit();
    }
}
