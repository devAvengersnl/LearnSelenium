package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class FacebookLoginPage extends AbstractPage {

    By btn_FBLogin = By.xpath("//input[@data-testid='royal_login_button']");

    public FacebookLoginPage(WebDriver driver) {
        super(driver);
    }

    protected By getUniqueElement() {
        return btn_FBLogin;
    }

    public void fbLoginExist() {
        Assert.assertTrue(driver.findElement(btn_FBLogin).isDisplayed());
    }

}
