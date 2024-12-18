package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public AbstractPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    protected void waitForVisible(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator);
    }
    protected String getText(By locator){
        waitForVisible(locator);
        return driver.findElement(locator).getText();
    }
    protected void sendText(By locator,String text){
        driver.findElement(locator).sendKeys(text);
    }
    protected void clickOnElement(By locator){
        driver.findElement(locator).click();
    }
    protected void waitAndSelect(By locator, String value){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element=driver.findElement(locator);
        Select dropdown = new Select(element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        dropdown.selectByVisibleText(value);
    }
}
