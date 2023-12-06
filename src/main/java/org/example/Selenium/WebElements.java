package org.example.Selenium;

public class WebElements {
    public WebElements() {

    }

    public static String getDriver() {
        return Driver;
    }

    public static void setDriver(String driver) {
        Driver = driver;
    }

    public static String getPath() {
        return path;
    }

    public static void setPath(String path) {
        WebElements.path = path;
    }


    public static String Driver = "webdriver.chrome.driver";
    public static String path = "H:\\Drivers\\ChromeDriver\\chromedriver-win64\\chromedriver.exe";;


}
