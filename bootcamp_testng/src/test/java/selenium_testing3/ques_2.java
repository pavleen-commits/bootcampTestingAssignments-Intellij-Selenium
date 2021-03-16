//ques 2: Write an automation script for filling all fields of the registration page. (Registration.html)
//But make sure that test data should be provided from a properties file.
//https://accounts.lambdatest.com/register
package selenium_testing3;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class ques_2 {
    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://accounts.lambdatest.com/register");
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Properties obj = new Properties();
        FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\ques2.properties");
        obj.load(objfile);
        driver.findElement(By.name("name")).sendKeys(obj.getProperty("name"));
        driver.findElement(By.name("email")).sendKeys(obj.getProperty("email"));
        driver.findElement(By.name("password")).sendKeys(obj.getProperty("password"));
        driver.findElement(By.name("phone")).sendKeys(obj.getProperty("phone"));
        Thread.sleep(2000);
        driver.close();
    }
}
