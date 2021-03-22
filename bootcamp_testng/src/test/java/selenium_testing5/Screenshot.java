package selenium_testing5;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void main(String[] ARGS) throws IOException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //casting driver obj to take ss using method getScreenshotAs
        //get output in a file format = OUTPUT.type : which we'll store in src.
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //bring ss to desktop
        FileUtils.copyFile(src, new File("D://screenshot.png"));
        driver.get("https://www.google.com//");

    }
}
