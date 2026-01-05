package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.*;

public class duplicatedropdowns
{
    static WebDriver driver;

    @Test
    public static void logic()
    {
      Map<String, Object> prefs = new HashMap<>();
      prefs.put("profile.default_content_setting_values.notifications", 2); // 1=Allow, 2=Block

      ChromeOptions options = new ChromeOptions();
      options.addArguments("--disable-infobars");
      options.addArguments("--disable-extensions");
      options.addArguments("--remote-allow-origins=*");
      options.setExperimentalOption("prefs", prefs);

      driver = new ChromeDriver(options);
      driver.get("https://www.orangehrm.com/en/book-a-free-demo");
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
      driver.manage().window().maximize();

      By dropdown_country = By.xpath("//select[@id=\"Form_getForm_Country\"]");

      WebElement ele = driver.findElement(dropdown_country);
      Select sel = new Select(ele);
      sel.selectByValue("Oman");

      List<WebElement> dropdown_options =sel.getOptions();

        Set<WebElement>unique = new HashSet<>();
        for (WebElement option : dropdown_options)
        {
            unique.add(option);
        }
        System.out.println(unique);
        System.out.println("Size of Dropdown = "+unique.size());

        driver.quit();

    }
}
