package pages;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        isLoaded();
    }

    protected abstract By getUniqueElement();

    private void isLoaded() throws Error {
        //Define a list of WebElements that match the unique element locator for the page
        if(getUniqueElement()!=null){

            List<WebElement> elements = driver.findElements(getUniqueElement());

            // Assert that the unique element is present in the DOM
            Assert.assertTrue(
                    "Unique Element \'" +
                            getUniqueElement().toString() +
                            "\' not found for " + this.getClass().getSimpleName(),
                    elements.size() > 0);

            // Wait until the unique element is visible in the browser and ready to use. This helps make sure the page is
            // loaded before the next step of the tests continue.
            wait.until(ExpectedConditions.visibilityOfElementLocated(getUniqueElement()));
        }


    }
}
