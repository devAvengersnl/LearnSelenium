package step_definitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CreateNewComputerPage;
import pages.LandingPage;


public class DEF_cucumberJava {

    LandingPage landingPage = null;
    CreateNewComputerPage createNewComputerPage = null;

    @Before
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
    }

    WebDriver driver = null;

    @Given("^I have open the browser$")
    public void i_have_open_the_browser() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver = new ChromeDriver();
    }

    @When("I open Facebook website")
    public void i_open_Facebook_website() {
        // Write code here that turns the phrase above into concrete actions
        driver.navigate().to("https://www.facebook.com/");
    }

    @Then("Login button should exits")
    public void login_button_should_exits() {
        Assert.assertTrue(driver.findElement(By.cssSelector("#loginbutton")).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @When("^I open Computer database website$")
    public void iOpenComputerDatabaseWebsite() throws Throwable {
        driver.navigate().to("https://computer-database.herokuapp.com/computers");
        landingPage = new LandingPage(driver);
    }

    @When("^I fill computer details$")
    public void iFillComputerDetails() throws Throwable {
        createNewComputerPage.fillComputerName("test");
        createNewComputerPage.fillIntroducedDate("1991-01-01");
        createNewComputerPage.fillDiscontinuedDate("1991-01-01");
        createNewComputerPage.selectCompany("Samsung Electronics");
        landingPage = createNewComputerPage.submitComputer();
    }

    @Then("^I should be able to add a computer$")
    public void iShouldBeAbleToAddAComputer() throws Throwable {
        landingPage.verfiyHeaderMessage();
    }

    @When("^I click add button$")
    public void iClickAddButton() throws Throwable {
        createNewComputerPage = landingPage.clickAddNewComputer();
    }

    @Given("^I have open the \"([^\"]*)\" browser$")
    public void iHaveOpenTheBrowser(String browserName) throws Throwable {
        if(browserName.equals("chrome")){
            driver = new ChromeDriver();
        } else if(browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        }

    }
}
