package selenium_testing5;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;


public class BrokenLinksAndAssertions {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //broken URL
        // we'll fetch urls(selenium) & check the status of url's (to find broken urls) using java methods
        //status code>400 : broken
        //for a single link
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        /*
        driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
        String url = driver.findElement(By.linkText("SoapUI")).getAttribute("href");
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("HEAD");
        conn.connect();
        int status = conn.getResponseCode();
        System.out.println(status);
        */

        //for all links on the page


        /*
        List<WebElement> list = driver.findElements(By.cssSelector("li[class='gf-li'] a"));

        for(WebElement link :list){
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int status = conn.getResponseCode();
            if(status>400){
                System.out.println("Link with text " +link.getText()+" is broken with code"+status);
                //yhii pe ruk gyii execution, agar aage koi aur broken link hui ? : Use soft assert
                //for this purpose
                Assert.assertTrue(false);
            }

        }

         */
        //using soft assert
        List<WebElement> list = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a = new SoftAssert();
        for (WebElement link : list) {
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");
            conn.connect();
            int status = conn.getResponseCode();
            a.assertTrue(status < 400, "Link with text " + link.getText() + " is broken with code" + status);


        }
        a.assertAll();
    }
}
