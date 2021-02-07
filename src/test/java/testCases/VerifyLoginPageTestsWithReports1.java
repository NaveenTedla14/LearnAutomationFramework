package testCases;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import factory.browserFactory;
import factory.dataProviderFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;
import utility.Helper;

public class VerifyLoginPageTestsWithReports1 {
    WebDriver driver;
    ExtentReports report;
    ExtentTest logger;
    @BeforeMethod
    public void setUp()
    {
        report = new ExtentReports("./reports/LoginPageReports.html",true);
        logger= report.startTest("Verify Loginpage");
        driver=browserFactory.getBrowser("chrome");
        driver.get(dataProviderFactory.getConfig().getAppURL());
        logger.log(LogStatus.INFO,"Application is up and Running");
    }
    @Test
    public void testSignInPage()
    {
        HomePage home= PageFactory.initElements(driver, HomePage.class);
        String title=home.getAppTitle();
        Assert.assertTrue(title.contains("Gmail"));
        logger.log(LogStatus.INFO,"Homepage loaded successfully and verified");
        SignInPage signin= PageFactory.initElements(driver, SignInPage.class);
        signin.loginApplication(dataProviderFactory.getExcel().getData(0,0,0),dataProviderFactory.getExcel().getData(0,0,1));
        logger.log(LogStatus.PASS,"Successfully entered username");
        logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShot(driver,"LoginValidation")));
    }
    @AfterMethod
    public void tearDown(ITestResult result)
    {
        if(result.getStatus()==ITestResult.FAILURE)
        {
            String path=Helper.captureScreenShot(driver,result.getName());
            logger.log(LogStatus.FAIL,logger.addScreenCapture(path));
        }
        browserFactory.closeBrowser(driver);
        report.endTest(logger);
        report.flush();
    }

}
