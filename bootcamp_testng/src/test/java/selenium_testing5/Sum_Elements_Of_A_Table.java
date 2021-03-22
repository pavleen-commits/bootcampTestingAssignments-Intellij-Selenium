package selenium_testing5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class Sum_Elements_Of_A_Table {

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
        List<WebElement> list = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            //text
            //list.get(i).getText();

            //convert it to integer
            //Integer.parseInt( "list.get(i).getText()");

            //adding
            sum = sum + Integer.parseInt(list.get(i).getText());
        }
        System.out.println(sum);

        //verifying the sum value from the value given at webpage
        //[0] : total amount collected [1]: 296
        //string op
        System.out.println(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
        //assertion
        Assert.assertEquals(sum,total);
        driver.close();


    }
}

