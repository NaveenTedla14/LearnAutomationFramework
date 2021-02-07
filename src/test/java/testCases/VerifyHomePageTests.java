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

public class VerifyHomePageTests {
    WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        driver=browserFactory.getBrowser("chrome");
        driver.get(dataProviderFactory.getConfig().getAppURL());
    }
    @Test
    public void testHomePage()
    {
        HomePage home= PageFactory.initElements(driver, HomePage.class);
        String title=home.getAppTitle();
        Assert.assertTrue(title.contains("Gmail"));
    }
    @AfterMethod
    public void tearDown()
    {
        browserFactory.closeBrowser(driver);
    }

}
