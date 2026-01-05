package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.time.Duration;

public class ipaddress
{
    @Test
    public static void RunIPAddress() throws MalformedURLException, UnknownHostException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        String href = driver.getCurrentUrl();

        URL url = new URL(href);
        String hostName = url.getHost();
        System.out.println("Host Name : " + hostName);

        InetAddress address = InetAddress.getByName(hostName);
        String ip = address.getHostAddress();
        System.out.println("IP Address : " + ip);


    }
}
