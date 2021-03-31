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

    @Given("I want to add my email {string}")
    public void i_want_to_add_my_email(String string) {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\nv95j\\OneDrive\\Skrivbord\\Selenium\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("https://login.mailchimp.com/signup/");
        driver.manage().window().maximize();

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(string);
    }
    @Given("I also want to set an username {string}")
    public void i_also_want_to_set_an_username(String string) {
        // Write code here that turns the phrase above into concrete actions
        if (string.equals("randUser")) {
            WebElement username = driver.findElement(By.id("new_username"));
            username.sendKeys(RandomStringUtils.randomAlphabetic(12));

        }
        else if (string.equals("randUser100")){
            WebElement username = driver.findElement(By.id("new_username"));
            username.sendKeys(RandomStringUtils.randomAlphabetic(110));
        }
        else if (string.equals("oldUser")){

            WebElement username = driver.findElement(By.id("new_username"));
            String nameUser = (RandomStringUtils.randomAlphabetic(12));
            username.sendKeys(nameUser);
        }
        else {
            WebElement username = driver.findElement(By.id("new_username"));
            username.sendKeys(RandomStringUtils.randomAlphabetic(12));
        }
    }

    @Given("I want to set a Password {string}")
    public void i_want_to_set_a_password(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement password = driver.findElement(By.id("new_password"));
        password.sendKeys(string);
        WebElement pop = driver.findElement(By.id("onetrust-accept-btn-handler"));
        pop.click();
    }

    @When("I press signup")
    public void i_press_signup() {
        // Write code here that turns the phrase above into concrete actions
        WebElement signUp = driver.findElement(By.cssSelector("#create-account"));
        signUp.click();

    }

    @Then("When user is {string} then the {string} should be.")
    public void when_user_is_then_the_should_be(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        if (string.equals("randUser")){
            WebElement firstResult = driver.findElement(By.cssSelector("#signup-content > div > div > div > span > label"));
            assertEquals(string2, firstResult.getText());
        }
       else{
            WebElement secResult = driver.findElement(By.cssSelector("#av-flash-errors > ul"));
            assertEquals(string2, secResult.getText());
        }
        driver.quit();
    }


}
