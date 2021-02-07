package factory;

import dataprovider.configDataProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class browserFactory {
    static WebDriver driver;
    public static WebDriver getBrowser(String browserName)
    {
        if(browserName.equalsIgnoreCase("firefox"))
        {
            driver=new FirefoxDriver();

        }
        else if(browserName.equalsIgnoreCase("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",dataProviderFactory.getConfig().getChrompath());
            driver= new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("IE"))
        {
            driver=new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    public static void closeBrowser(WebDriver driver)
    {
        driver.quit();
    }
}
