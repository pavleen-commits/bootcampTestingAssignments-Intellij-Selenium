package live_automation_1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Enabled_Disabled {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");

        if (!driver.findElement(By.cssSelector("input[type='text']")).isEnabled()) {
            System.out.println("TextBox Disabled");
            driver.findElement(By.xpath("//*[@id='input-example']/button")).click();
            System.out.println("TextBox Enabled");
        }
        WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        System.out.println("Its enabled");
        element.findElement(By.xpath("//*[@id='input-example']/input")).sendKeys("Pavleen");
        element.findElement(By.xpath("//*[@id='input-example']/button")).click();
        WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        System.out.println("Its Disabled!");
        Thread.sleep(1000);

        driver.close();
    }
}