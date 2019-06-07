package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateNewComputerPage extends AbstractPage{

    public CreateNewComputerPage(WebDriver driver) {
        super(driver);
    }

    By btnCreateComputer = By.xpath("//input[@class='btn primary']");
    By btnCancel = By.linkText("Cancel");
    By txtComputerName = By.id("name");
    By txtIntroduceDate = By.id("introduced");
    By txtDiscontinuedDate = By.id("discontinued");
    By selectCompanyName = By.id("company");

    protected By getUniqueElement() {
        return btnCreateComputer;
    }

    public void fillComputerName(String cmpName) {
        driver.findElement(txtComputerName).sendKeys(cmpName);
    }

    public void fillIntroducedDate(String intDate) {
        driver.findElement(txtIntroduceDate).sendKeys(intDate);
    }

    public void fillDiscontinuedDate(String disDate) {
        driver.findElement(txtDiscontinuedDate).sendKeys(disDate);
    }

    public void selectCompany(String cmp) {
        Select _companyName = new Select(driver.findElement(selectCompanyName));
        _companyName.selectByVisibleText(cmp);
    }

    public LandingPage submitComputer() {
        driver.findElement(btnCreateComputer).click();
        return new LandingPage(driver);
    }

}
