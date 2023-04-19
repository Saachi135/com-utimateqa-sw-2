package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    //public static string baseurl
    public static WebDriver driver;

    public void openBrowser(String baseUrl){
        // open chrowe browser
        driver = new ChromeDriver();
        // open url into the browser
        driver.get(baseUrl);

    }
    public void closeBrowser(){
        driver.quit(); // close browser
    }
}
