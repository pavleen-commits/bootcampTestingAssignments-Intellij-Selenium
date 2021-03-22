package selenium_testing5;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.*;
import java.util.stream.Collectors;

public class WebTableSorting {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//tr/th[1]")).click();
        List<WebElement> list = driver.findElements(By.xpath("//tr//td[1]"));
        List<String> str = list.stream().map(s -> s.getText()).collect(Collectors.toList());

        List<String> str_sorted = str.stream().sorted().collect(Collectors.toList());
        Assert.assertTrue(str.equals(str_sorted));



    }
}
