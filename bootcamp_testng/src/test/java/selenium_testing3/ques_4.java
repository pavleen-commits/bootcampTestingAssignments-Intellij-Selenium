//Q4- Print the order of TestNG annotations?
package selenium_testing3;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ques_4 {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite method");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("After Suite method");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test method");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("After Test method");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class method");
    }

    @BeforeGroups(groups = {"testOne"})
    public void beforeGroupOne(){
        System.out.println("Before Group Test One method");
    }
    @AfterGroups(groups={"testOne"})
    public void afterGroupOne(){
        System.out.println("After Group Test One method");
    }
    @BeforeGroups(groups={"testTwo"})
    public void beforeGroupTwo(){
        System.out.println("Before Group Test two method");
    }
    @AfterGroups(groups={"testTwo"})
    public void afterGroupTwo(){
        System.out.println("After Group Test two method");
    }


    @BeforeMethod(alwaysRun=true)
    public void beforeMethod(){
        System.out.println("Before Method");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @Test(groups={"testOne"})
    public void testOneMethod(){
        System.out.println("Test one method");
    }
    @Test(groups={"testTwo"})
    public void testTwoMethod(){
        System.out.println("Test two method");
    }


}





