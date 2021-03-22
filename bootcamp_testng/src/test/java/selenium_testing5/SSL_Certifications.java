package selenium_testing5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSL_Certifications {
    public static void main(String[] args)  {
        DesiredCapabilities ch = DesiredCapabilities.chrome();
        // method 1
        ch.acceptInsecureCerts();
        //method 2
        ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);


        ChromeOptions c = new ChromeOptions();
        c.merge(ch);
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(c);
        driver.get("www.google.com");
    }
}
