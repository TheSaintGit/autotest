package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    private WebDriver driver;
    Wait sendKeys = new Wait();
    Wait click = new Wait();

    @Given("I want to add my email {string}")
    public void i_want_to_add_my_email(String email) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nv95j\\OneDrive\\Skrivbord\\Selenium\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();

       sendKeys.sendKeys(driver, By.id("email"), email);
    }

    @Given("I also want to set an username {string}")
    public void i_also_want_to_set_an_username(String userName) {

        switch (userName) {
            case "randUser" -> sendKeys.sendKeys(driver, By.id("new_username"), (RandomStringUtils.randomAlphabetic(12)));
            case "randUser100" -> sendKeys.sendKeys(driver, By.id("new_username"), (RandomStringUtils.randomAlphabetic(110)));
            case "oldUser" -> sendKeys.sendKeys(driver, By.id("new_username"), ("oldUser"));
            default -> sendKeys.sendKeys(driver, By.id("new_username"), (RandomStringUtils.randomAlphabetic(13)));
        }
    }

    @Given("I want to set a Password {string}")
    public void i_want_to_set_a_password(String passWord) {
        sendKeys.sendKeys(driver, By.id("new_password"), (passWord));
        click.click(driver, By.id("onetrust-accept-btn-handler"));
    }

    @When("I press signup")
    public void i_press_signup() {
        click.click(driver, By.cssSelector("#create-account"));
    }

    @Then("When user is {string} then the {string} should be.")
    public void when_user_is_then_the_should_be(String userName, String result) {
        switch (userName) {
            case "randUser" -> {
                WebElement firstResult = driver.findElement(By.cssSelector("#signup-content > div > div > div > span > label"));
                assertEquals(result, firstResult.getText());
            }
            case "randUser100" -> {
                WebElement secResult = driver.findElement(By.cssSelector("#signup-form > fieldset > div:nth-child(2) > div > span"));
                assertEquals(result, secResult.getText());
            }
            case "oldUser" -> {
                WebElement secResult = driver.findElement(By.cssSelector(".invalid-error"));
                assertEquals(result, secResult.getText());
            }
            default -> {
                WebElement secResult = driver.findElement(By.cssSelector("#signup-form > fieldset > div:nth-child(1) > div > span"));
                assertEquals(result, secResult.getText());
            }
        }
        driver.quit();
    }
}
