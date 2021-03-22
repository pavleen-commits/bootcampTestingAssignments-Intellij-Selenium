package selenium_testing5;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Scrolling {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //takes 2 args, but arg2 is optional
        //window scroll
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(2000);
        //element scroll
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");
        driver.close();



    }
}
