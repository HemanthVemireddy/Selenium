package Abstraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface UIActions
{
    public void ClickElement(By locator);
    public void EnterText(WebElement element, String text);
    public void GetText(WebElement element, String expectedText);
}
