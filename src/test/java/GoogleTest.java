import TestRailManager.testrailmanager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleTest{
    public String  testcaseid;

    @Parameters("Browser")
    @Test()
    public void validateGoogleImage(String browsername){
        testcaseid="1";
        WebDriver driver=null;
        if(browsername.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        }
        else if(browsername.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
          driver =new FirefoxDriver();
        }
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@alt='Google']"));
    }


   @Parameters("Browser")
   @Test
    public void sendSerachTestToGoogle(String browsername) {
         testcaseid="2";
        WebDriver driver=null;
        if(browsername.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            driver =new ChromeDriver();
        }
        else if(browsername.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver =new FirefoxDriver();
        }

        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@title='Search']"));
    }

    @AfterMethod
        public void addTestResultToTestRail(ITestResult results){
        if(results.getStatus()==ITestResult.SUCCESS){
            testrailmanager.addTestCaseStatusToTestRail(testcaseid,testrailmanager.TEST_CASE_PASS_STATUS,"");
        }
        else if(results.getStatus()==ITestResult.FAILURE){
            testrailmanager.addTestCaseStatusToTestRail(testcaseid,testrailmanager.TEST_CASE_FAIL_STATUS,"Failing due to unknown reason");
        }
        }

        }

