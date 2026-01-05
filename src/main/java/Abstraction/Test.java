package Abstraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Test
{
    public static void main(String[] args)
    {
        UIActions actions = new ActionHelper();
        WebElement el = null;
        actions.ClickElement((By) el);
    }

}
