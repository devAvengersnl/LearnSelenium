package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LandingPage extends AbstractPage {

    By btn_addComputer = By.id("add");
    By alert_Message = By.xpath("//div[@class='alert-message warning']");

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    protected By getUniqueElement() {
        return btn_addComputer;
    }

    public CreateNewComputerPage clickAddNewComputer() {
        driver.findElement(btn_addComputer).click();
        return new CreateNewComputerPage(driver);
    }

    public void verfiyHeaderMessage() {
        Assert.assertTrue("header message", driver.findElement(alert_Message).getText().equals("Done! Computer test has been created"));
    }

}
