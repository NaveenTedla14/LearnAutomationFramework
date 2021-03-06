package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver ldriver)
    {
        this.driver=ldriver;
    }
    @FindBy(xpath = "//a[text()='Sign In']") WebElement signInLink;
    @FindBy(xpath = "//a[text()='My account']") WebElement myaccountLink;
    @FindBy(xpath = "//a[text()='My cart']") WebElement myCartLink;
    @FindBy(xpath = "//a[text()='Checkout']") WebElement checkoutlink;

    public void clickOnSignInLink()
    {
        signInLink.click();
    }
    public void clickOnMyAccountLink()
    {
        myaccountLink.click();
    }
    public void clickOnMyCartLink()
    {
        myCartLink.click();
    }
    public void clickOnCheckoutlink()
    {
        checkoutlink.click();
    }
    public String getAppTitle()
    {
        return driver.getTitle();

    }

}
