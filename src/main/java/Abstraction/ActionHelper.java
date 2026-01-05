package Abstraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionHelper  implements UIActions{
    protected WebDriver driver;
    @Override
    public void ClickElement(By locator) {
        driver.findElement(locator).click();
    }

    @Override
    public void EnterText(WebElement element, String text) {
    element.sendKeys(text);
    }

    @Override
    public void GetText(WebElement element, String expectedText) {
    }
}
