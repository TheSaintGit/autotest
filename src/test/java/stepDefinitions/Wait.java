package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    void sendKeys(WebDriver driver,By by, String keys) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(by));
        driver.findElement(by).sendKeys(keys);
    }
    void click(WebDriver driver,By by) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }
}

