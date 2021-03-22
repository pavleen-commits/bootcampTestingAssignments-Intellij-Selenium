package selenium_testing5;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Cookies {
    public static void main(String[] ARGS) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //maximize window
        driver.manage().window().maximize();
        /*
        //deleting the cookies
        driver.manage().deleteAllCookies();

        //if you know the cookies name
        driver.manage().deleteCookieNamed("NameOfCookie");
        //deleting session cookie to make sure that the logged in user gets logged out automatically
        driver.manage().deleteCookieNamed("SessionCookie name ");
        //now you should be directed to login

         */

        driver.get("https://www.google.com/?gws_rd=ssl");
    }
}
