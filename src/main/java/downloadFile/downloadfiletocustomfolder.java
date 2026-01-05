package downloadFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static java.lang.Thread.sleep;

public class downloadfiletocustomfolder
{
    @Test
    public static void CustomDownload() {
        String jenkinsFolderPath = System.getProperty("user.dir") + File.separator + "JenkinsDownloads";
        File jenkisDownloadFile = new File(jenkinsFolderPath);
        if (!jenkisDownloadFile.exists()) {
            System.out.println("Jenkins folder not present");
        } else if (jenkisDownloadFile.mkdir()) {
            System.out.println("Created Jenkins file downloaded at folder");
        }

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", jenkinsFolderPath);
        prefs.put("download.prompt_for_download", false);

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);

        WebDriver driver = new ChromeDriver();
        driver.get("https://get.jenkins.io/war-stable/2.528.3/jenkins.war");

        File file = new File(jenkisDownloadFile, "jenkins.war");

        int timeoutSeconds = 30;
        int waited = 0;

        while (waited < timeoutSeconds && !file.exists()) {
            try {
                sleep(1000);
                waited++;
                System.out.println("Waiting... " + waited + "s");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Thread interrupted while waiting", e);
            }
        }

        if (file.exists() && file.length() > 0) {
            System.out.println("File downloaded successfully");
        } else {
            System.err.println("Download fail");

        }
    }
}
