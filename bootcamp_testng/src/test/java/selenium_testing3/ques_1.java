//ques 1:  https://www.ultimateqa.com/simple-html-elements-for-automation/
//Fetch Quality Assurance Engineer Salary from the table under HTML Table with no id.
//The code should be dynamic.
package selenium_testing3;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.util.List;
public class ques_1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://ultimateqa.com/simple-html-elements-for-automation/");
        driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);


        //Static Approach

        //driver.findElement(By.xpath(" //*[@id=\"post-909\"]//div[5]//table")).getText(); -entire table
        //List<WebElement> element =driver.findElements(By.xpath(" //*[@id=\"post-909\"]//div[5]//table//tbody//tr")); -no of rows
        //List<WebElement> element =driver.findElements(By.xpath("//*[@id=\"post-909\"]/div/div[1]//div[5]//table/tbody/tr/th")); -no of columns
        //System.out.println(element.size());
        String str = driver.findElement(By.xpath(" //*[@id=\"post-909\"]/div/div[1]//div[5]//table/tbody/tr[4]/td[3]")).getText();
        System.out.println("Static Salary is " +str);


        //Dynamic Approach -1
        //String title = "Software Development Engineer in Test" ;
        String title = "Quality Assurance Engineer" ;
        WebElement table = driver.findElement(By.xpath("//*[@id=\"post-909\"]//div[5]/div/table//tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for(int i=1; i< rows.size();i++){
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            //System.out.println(rows.get(i).getText());
            //System.out.println(columns.get(0).getText());
            if(columns.get(0).getText().equals(title)){
                //System.out.println("Hello");
                System.out.println("Dynamic Salary is " +columns.get(2).getText());
            }
        }


        //Dynamic Approach -2
        String text="Quality";
        WebElement value = driver.findElement(By.xpath("(//table)[2]//tr//td[contains(text(), text)]//following-sibling::td[2]"));
        String rowText=value.getText();
        System.out.println(rowText);
        driver.close();

    }
}
