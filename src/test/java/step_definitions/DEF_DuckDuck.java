package step_definitions;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.DuckLandingPage;
import pages.FacebookLoginPage;
import pages.SearchResultPage;

public class DEF_DuckDuck {

    WebDriver driver = null;
    DuckLandingPage duckLandingPage = null;
    SearchResultPage searchResultPage = null;
    FacebookLoginPage facebookLoginPage = null;

    @Before
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^I have open the \"([^\"]*)\" browser$")
    public void iHaveOpenTheBrowser(String browserName) throws Throwable {
        DesiredCapabilities caps = null ;
        if(browserName.equals("chrome")){
            caps = DesiredCapabilities.chrome();
//            driver = new ChromeDriver();
        } else if(browserName.equals("firefox")) {
//            driver = new FirefoxDriver();
            caps = DesiredCapabilities.firefox();
        }
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),caps);

    }

    @When("^I open Duck Duck Go database website$")
    public void iOpenDuckDuckGoDatabaseWebsite() throws Throwable {
        driver.navigate().to("https://duckduckgo.com/");
        duckLandingPage = new DuckLandingPage(driver);
    }

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchForFacebook(String searchParameter) throws Throwable {
        searchResultPage = duckLandingPage.searchBy(searchParameter);
    }

    @And("^I click first link$")
    public void iClickFirstLink() throws Throwable {
        facebookLoginPage = searchResultPage.clickFirstLink();
    }

    @Then("^I should see facebook login page$")
    public void iShouldSeeFacebookLoginPage() throws Throwable {
        facebookLoginPage.fbLoginExist();
    }
}
