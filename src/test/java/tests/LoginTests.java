package tests;

import BaseTest.TestBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.util.List;

public class LoginTests extends TestBase {
    LoginPage loginPage;
    private static final Logger logger = LogManager.getLogger(LoginTests.class);
    @Test
    public void testLogin(){
        loginPage = new LoginPage(driver);
        loginPage.enterUserName("standard_user").enterPassword("secret_sauce").clickOnLogin();
        logger.info("Title of page is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Swag Labs");
    }
    @Test
    public void testProductsCount() {
        loginPage = new LoginPage(driver);
        loginPage.enterUserName("standard_user").enterPassword("secret_sauce").clickOnLogin();
        List<WebElement> productNames = driver.findElements(By.cssSelector("[data-test='inventory-item-name']"));
        logger.info(productNames.size());
        Assert.assertEquals(productNames.size(),6);
    }
}
