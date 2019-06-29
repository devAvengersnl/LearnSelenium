package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SearchResultPage extends AbstractPage {

    By input_Search = By.id("search_form_input");
    By str_firstResult = By.xpath("//a[contains(text(),'- Log In or Sign Up')]");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    protected By getUniqueElement() {
        return input_Search;
    }

    public FacebookLoginPage clickFirstLink() {
        driver.findElement(str_firstResult).click();
        return new FacebookLoginPage(driver);
    }

}
