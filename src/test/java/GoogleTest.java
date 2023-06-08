import TestRailManager.testrailmanager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class GoogleTest{
    public String  testcaseid;

    @Test()
    public void validateGoogleImage(){
        testcaseid="1";
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@alt='Google']"));
    }

    @Test
    public void sendSerachTestToGoogle() {
         testcaseid="2";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
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

