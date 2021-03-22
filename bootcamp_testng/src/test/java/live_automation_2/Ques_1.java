//ques1: http://automationpractice.com/index.php?controller=authentication&back=my-account
//Successful registration with valid data
package live_automation_2;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;
public class Ques_1 {
    @Test
    public void register() throws InterruptedException{

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");
        //adding data in email feild
        driver.findElement(By.id("email_create")).sendKeys("abcde@bye.com");
        driver.findElement(By.id("SubmitCreate")).click();

        SoftAssert s = new SoftAssert();
        String title = "Login - My Store";
        String t = driver.getTitle();
        s.assertEquals(title, t);
        System.out.println("Title Validated");

        Boolean text = driver.getPageSource().contains("Create an account");
        s.assertTrue(text);
        System.out.println("Text Validated");

        //add personal details
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.name("customer_firstname")).sendKeys("ABC");
        driver.findElement(By.name("customer_lastname")).sendKeys("DEF");
        driver.findElement(By.id("passwd")).sendKeys("12345");

        Select day = new Select(driver.findElement(By.id("days")));
        day.selectByValue("14");
        Select month = new Select(driver.findElement(By.id("months")));
        month.selectByValue("11");
        Select year = new Select(driver.findElement(By.id("years")));
        year.selectByValue("1999");

        driver.findElement(By.id("newsletter")).click();
        driver.findElement(By.id("uniform-optin")).click();

        js.executeScript("window.scrollBy(0,200)");

        driver.findElement(By.id("firstname")).sendKeys("ABC");
        driver.findElement(By.id("lastname")).sendKeys("DEF");

        driver.findElement(By.id("company")).sendKeys("TO THE NEW");
        driver.findElement(By.id("address1")).sendKeys("H.No: 71/40-A");
        driver.findElement(By.id("address2")).sendKeys("Nehru Nagar");
        driver.findElement(By.id("city")).sendKeys("Roorkee");

        Select state = new Select(driver.findElement(By.id("id_state")));
        state.selectByIndex(5);
        driver.findElement(By.id("postcode")).sendKeys("00000");
        driver.findElement(By.id("other")).sendKeys("Okay Byee");
        driver.findElement(By.id("phone")).sendKeys("8433229795");
        driver.findElement(By.id("phone_mobile")).sendKeys("8878879494797");
        driver.findElement(By.id("alias")).sendKeys("Hello");


        driver.findElement(By.id("submitAccount")).click();

        Thread.sleep(2000);
        Boolean text1 = driver.getPageSource().contains("Sign out");
        s.assertTrue(text1);
        System.out.println("New User Registration Validated");

        s.assertAll();
        driver.close();

    }
}


