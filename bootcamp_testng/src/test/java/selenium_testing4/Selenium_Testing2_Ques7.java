//Q7- https://www.myntra.com/ (Will be covered with session 4/5)
//Mouse hover on the Home &
//Living tab then click clock, now validate that navigated URL is for clock section.
package selenium_testing4;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Selenium_Testing2_Ques7 {
    public static void main(String[] args) throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.myntra.com/ ");
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.cssSelector("a[data-group^='home']"));
        actions.moveToElement(menu).perform();
        driver.findElement(By.cssSelector("a[data-reactid='535']")).click();
        String s1=driver.getCurrentUrl(); String s2="https://www.myntra.com/clocks";
        System.out.println("Expected URL " + s2);
        System.out.println("Actual URL " + s1);
        SoftAssert a = new SoftAssert();
        a.assertEquals(s2,s1);
        driver.close();
    }
}
