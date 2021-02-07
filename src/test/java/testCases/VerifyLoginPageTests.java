package testCases;

import factory.browserFactory;
import factory.dataProviderFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SignInPage;

public class VerifyLoginPageTests {
    WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        driver=browserFactory.getBrowser("chrome");
        driver.get(dataProviderFactory.getConfig().getAppURL());
    }
    @Test
    public void testSignInPage()
    {
        HomePage home= PageFactory.initElements(driver, HomePage.class);
        String title=home.getAppTitle();
        Assert.assertTrue(title.contains("Gmail"));
        SignInPage signin= PageFactory.initElements(driver, SignInPage.class);
        signin.loginApplication(dataProviderFactory.getExcel().getData(0,0,0),dataProviderFactory.getExcel().getData(0,0,1));

    }
    @AfterMethod
    public void tearDown()
    {
        browserFactory.closeBrowser(driver);
    }

}
