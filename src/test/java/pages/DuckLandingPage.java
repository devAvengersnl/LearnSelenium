package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class DuckLandingPage extends AbstractPage {

    By input_Search = By.id("search_form_input_homepage");
    By str_firstResult = By.xpath("//div[contains(@class,'acp-wrap js-acp-wrap')]//div[1]");

    public DuckLandingPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 30);
    }

    protected By getUniqueElement() {
        return input_Search;
    }

    public SearchResultPage searchBy(String paramter) {
        driver.findElement(input_Search).sendKeys(paramter);
        wait.until(ExpectedConditions.visibilityOfElementLocated(str_firstResult));
        driver.findElement(str_firstResult).click();
        return new SearchResultPage(driver);
    }

    public DuckLandingPage get() {
        driver.navigate().to("https://duckduckgo.com/");
        return new DuckLandingPage(driver);
    }

}
