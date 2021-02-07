package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

public class SignInPage {
    WebDriver driver;
    public SignInPage( WebDriver ldriver)
    {
        this.driver=ldriver;
    }
    @FindBy(xpath = "(//a[contains(text(),'Sign in') and @ga-event-action='sign in'])[2]") WebElement signInButton;
    @FindBy(xpath = "//input[@type='email']") WebElement emailName;
    @FindBy(xpath = "//span[text()='Next']/following-sibling::div") WebElement nextButton;
    @FindBy(xpath = "//input[@type='password']") WebElement password;

    public void loginApplication(String username,String pass)
    {
        signInButton.click();
        ArrayList tabs = new ArrayList(driver.getWindowHandles());
        System.out.println(tabs.size());
        driver.switchTo().window((String) tabs.get(1));
        emailName.sendKeys(username);
        nextButton.click();
    }


}
