package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        WebElement username = driver.findElement(By.id("new_username"));
        username.sendKeys(string);


    }

    @Given("I want to set a Password {string}")
    public void i_want_to_set_a_password(String string) {
        // Write code here that turns the phrase above into concrete actions
        WebElement password = driver.findElement(By.id("new_password"));
        password.sendKeys(string);

    }

    @When("I press signup")
    public void i_press_signup() {
        // Write code here that turns the phrase above into concrete actions
        WebElement signUp = driver.findElement(By.cssSelector("#create-account"));
        signUp.click();

    }

    @Then("The {string} should be that i see a confirm page.")
    public void the_result_should_be_that_i_see_a_confirm_page(String string) {
        // Write code here that turns the phrase above into concrete actions

    }

}
