//ques4:  book a order than contact the customer care for that order
package live_automation_2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;

public class Ques_4 {
    @Test
    public void customer() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.id("email")).sendKeys("abcde@bye.com");
        driver.findElement(By.id("passwd")).sendKeys("12345");
        driver.findElement(By.id("SubmitLogin")).click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[3]/a"))));
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
        js.executeScript("window.scrollBy(0,1000)");
        driver.findElement(By.name("message")).sendKeys("Make it happen soon!");
        driver.findElement(By.name("processAddress")).click();
        js.executeScript("window.scrollBy(0,700)");
        driver.findElement(By.id("uniform-cgv")).click();
        driver.findElement(By.name("processCarrier")).click();
        js.executeScript("window.scrollBy(0,700)");
        driver.findElement(By.className("cheque")).click();
        js.executeScript("window.scrollBy(0,400)");
        driver.findElement(By.xpath("//*[@id='cart_navigation']/button")).click();
        js.executeScript("window.scrollBy(0,400)");

        String success = driver.findElement(By.className("alert-success")).getText();
        String actual = "Your order on My Store is complete.";
        SoftAssert a = new SoftAssert();
        a.assertEquals(actual, success);
        System.out.println("Order placed!");

        driver.findElement(By.linkText("customer service department.")).click();
        js.executeScript("window.scrollBy(0,400)");
        driver.findElement(By.name("message")).sendKeys("Defective Item Received");
        WebElement element = driver.findElement(By.id("id_contact"));
        Select s = new Select(element);
        s.selectByValue("2");

        WebElement element1 = driver.findElement(By.name(
                "id_order"));
        Select s1 = new Select(element1);
        s1.selectByValue("300583");


        driver.findElement(By.name("submitMessage")).click();
        String value = driver.findElement(By.className("alert-success")).getText();
        String t = "Your message has been successfully sent to our team.";
        a.assertEquals(t, value );
        System.out.println("Contacted customer care");

        a.assertAll();







    }
}
