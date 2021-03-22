//ques 5: Negative Testing: Try to place a order without signing in
package live_automation_2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;
public class Ques_5 {

    @Test
    public void negative(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a")).click();
        js.executeScript("window.scrollBy(0,600)");

        Actions actions = new Actions(driver);
        WebElement menu = driver.findElement(By.cssSelector("ul[class='color_to_pick_list clearfix']"));
        actions.moveToElement(menu).perform();


        driver.findElement(By.xpath("//a[contains(text() , 'Faded Short Sleeve T-shirts')] ")).click();
        js.executeScript("window.scrollBy(0,600)");
        driver.findElement(By.xpath("//*[@id='add_to_cart']/button")).click();
        driver.findElement(By.xpath("//*[@class='button-container']/a")).click();
        js.executeScript("window.scrollBy(0,1100)");
        driver.findElement(By.xpath("//*[@class='cart_navigation clearfix']/a[1]")).click();

        Boolean bool = driver.getPageSource().contains("Create an account");
        SoftAssert a = new SoftAssert();
        a.assertTrue(bool);
        System.out.println("You need to sign in first!");
        a.assertAll();
    }
}
